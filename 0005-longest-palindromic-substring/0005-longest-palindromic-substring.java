class Solution {
    public String longestPalindrome(String s) {
        int maxStart = 0;
        int maxEnd = 0;
        
        for (int i=0; i<s.length(); i++) {
            int start = i;
            int end = i;
            while (0 <= start && end < s.length() && s.charAt(start) == s.charAt(end)) {
                if (maxEnd - maxStart < end - start) {
                    maxStart = start;
                    maxEnd = end;
                }
                start--;
                end++;
            }
            
            start = i;
            end = i+1;
            while (0 <= start && end < s.length() && s.charAt(start) == s.charAt(end)) {
                if (maxEnd -maxStart < end - start) {
                    maxStart = start;
                    maxEnd = end;
                }
                start--;
                end++;
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }
}