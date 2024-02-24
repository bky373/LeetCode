class Solution {
    public int[] twoSum(int[] nums, int target) {
        int x = 0;
        for (int i=0; i < nums.length; i++) {
            x = nums[i];
            for (int j=i+1; j < nums.length; j++) {
                if ((x + nums[j]) == target) {
                    return new int[]{i,j};
                }
            }
        }        
        return new int[]{};
    }
}
