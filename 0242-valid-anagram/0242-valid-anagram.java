class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alpha = new int[26];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            alpha[s.charAt(i) - 'a']++;
        }
        
        if (n != t.length()) {
            return false;
        } else {
            n = t.length();
        }
        
        for (int i = 0; i < n; i++) {
            int idx = t.charAt(i) - 'a';
            if (alpha[idx] > 0) {
                alpha[idx]--;
            } else {
                return false;
            }
        }
        return true;
    }
}