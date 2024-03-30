class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] moved = new int[n];
        for (int i=0; i<n; i++) {
            int moveIdx = (i+k) % n;
            moved[moveIdx] = nums[i];
        }
        for (int i=0; i<n; i++) {
            nums[i] = moved[i];
        }
    }
}
