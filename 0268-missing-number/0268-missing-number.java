class Solution {
    public int missingNumber(int[] nums) {
        int[] rooms = new int[10001];
        for (int num : nums) {
            rooms[num] = 1;
        }
        for (int i = 0; i <= rooms.length; i++) {
            if (rooms[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}