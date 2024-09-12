class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length - 1 && nums[i] <= 0; ++i) {
            if (i == 0 || nums[i-1] != nums[i]) {
                twoSum(i, nums, result);
            }

        }
        return new ArrayList<>(result);
    }

    private void twoSum(int i, int[] nums, Set<List<Integer>> result) {
        int left = i+1;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum == 0) {
                result.add(List.of(nums[i], nums[left++], nums[right--]));
            } else if (sum < 0) {
                ++left;
            } else {
                --right;
            }
        }
    }
}
/**
 * TC: O(n^2), where n is the length of numbers
 * SC: O(logn), because of the sorting algorithm
 */
