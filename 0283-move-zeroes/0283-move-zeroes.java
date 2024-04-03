class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i=0;
        for (int x : nums) {
            if (x != 0) {
                nums[i++] = x;
            }
        }
        while (i < n) {
            nums[i++] = 0;
        }
    }
}
