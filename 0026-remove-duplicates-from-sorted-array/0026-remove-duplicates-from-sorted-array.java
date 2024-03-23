class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        int cursor = 0;
        int max = nums[0] - 1;
    
        for (int i=0; i<nums.length; i++) {
            if (max < nums[i]) {
                k++;
                max = nums[i];
                nums[cursor++] = max;
            }
        }
        return k;
    }
}
