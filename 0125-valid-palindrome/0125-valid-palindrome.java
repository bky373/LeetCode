class Solution {
    public boolean isPalindrome(String s) {
        if (s.isBlank() || s.length() == 1) {
            return true;
        }
        s = s.toLowerCase();
        int i=0, j=s.length() - 1;
        while (i<j) {
            if (!isAlphaNumeric(s.charAt(i))) {
                i++;
                continue;
            }
            if (!isAlphaNumeric(s.charAt(j))) {
                j--;
                continue;
            }
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;   
            }
        }
        return true;
    }
    
    public boolean isAlphaNumeric(char c) {
        return ('0' <= c && c <= '9') || ('a' <= c && c < 'z');
    }
}