class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] alpCnt = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alpCnt[s.charAt(i) - 'a']++;
            alpCnt[t.charAt(i) - 'a']--;
        }

        for (int cnt : alpCnt) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }
}