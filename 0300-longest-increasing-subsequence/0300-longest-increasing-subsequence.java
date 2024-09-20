/**
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 *
 * Approach 1: Dynamic Programming
 * - TC: O(n^2), where n is the length of nums
 * - SC: O(n), where n is the length of nums
 * - 점화식: dp[i] = max(dp[i], dp[j]+1), if nums[i] > nums[j]
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i=1; i<nums.length; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int longest = 0;
        for (int cnt : dp) {
            longest = Math.max(longest, cnt);
        }
        return longest;
    }
}

/**
 * Approach 2: Intelligently Build a Subsequence
 * - TC: O(n^2), where n is the length of nums
 * - SC: O(n), where n is the length of nums
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                // Find the first element in sub that is greater than or equal to num
                int j = 0;
                while (num > sub.get(j)) {
                    j++;
                }
                sub.set(j, num);
            }
        }
        return sub.size();
    }
}


/**
 * Approach 3: Improve With Binary Search
 * - TC: O(n*logn), where n is the length of nums
 * - SC: O(n), where n is the length of nums
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                int j = binarySearch(sub, num);
                sub.set(j, num);
            }
        }
        return sub.size();
    }

    private int binarySearch(List<Integer> sub, int target) {
        int left = 0;
        int right = sub.size() - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            int num = sub.get(mid);
            if (num == target) {
                return mid;
            } else if (num < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
