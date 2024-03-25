class Solution {
    public int firstUniqChar(String s) {
        int[] letterCounts = new int[26];
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            letterCounts[c - 97]++;
        }
        int i = 0;
        for (char c: charArray) {
            if (letterCounts[c - 97] == 1) {
                return i;
            }
            i++;
        }
        return -1;
    }
}