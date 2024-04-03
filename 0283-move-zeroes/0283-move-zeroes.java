class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (nums[i] != 0 && nums[j] != 0) {
                j++;
            } else if (nums[i] != 0 && nums[j] == 0 && i > j) {
                int tmp = nums[i];
                nums[i++] = 0;
                nums[j++] = tmp;
            } else {
                i++;
            }
        }
    }
}
