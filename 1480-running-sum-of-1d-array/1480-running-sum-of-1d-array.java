class Solution {
    public int[] runningSum(int[] nums) {
        var newArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                newArr[i] = nums[i];
            } else {
                newArr[i] += newArr[i - 1] + nums[i];
            }
        }
        return newArr;
    }
}