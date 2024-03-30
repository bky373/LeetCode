class Solution {
    public int singleNumber(int[] nums) {
        int sing = 0;
        for (int x: nums) {
            sing = sing^x;
        }
        return sing;
    }
}
