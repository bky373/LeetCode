class Solution {
    public int search(int[] nums, int target) {
        int res = -1;
        if (nums.length == 1 && nums[0] == target) {
            return 0;
        }
        int minIndex = findMinIndex(nums);
        int leftResult = binarySearch(nums, 0, minIndex -1, target);
        int rightResult = binarySearch(nums, minIndex, nums.length - 1, target);
        if (leftResult >= 0) {
            res = leftResult;
        } else if (rightResult >= 0) {
            res = rightResult;
        }
        return res;
    }
    
    private int findMinIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (nums[left] > nums[right]) {
            int mid = (left+right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left+right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}