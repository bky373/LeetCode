class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphaArr = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            alphaArr[magazine.charAt(i) - 97]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int idx = ransomNote.charAt(i) - 97;
            int cnt = alphaArr[idx];
            if (cnt == 0) {
                return false;
            }
            alphaArr[idx]--;
        }
        return true;
    }
}