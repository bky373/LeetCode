class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphaArr = new int[26];

        for (char m : magazine.toCharArray()) {
            var idx = (int) m - 97;
            alphaArr[idx]++;
        }
        for (char r : ransomNote.toCharArray()) {
            var idx = (int) r - 97;
            var cnt = alphaArr[idx];
            if (cnt == 0) {
                return false;
            }
            alphaArr[idx]--;
        }
        return true;
    }
}