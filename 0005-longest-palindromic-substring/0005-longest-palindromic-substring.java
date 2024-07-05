class Solution {
    int maxStart = 0;
    int maxEnd = 0;
    
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            calculateMaxLength(i, i, maxStart, maxEnd, s);
            calculateMaxLength(i, i+1, maxStart, maxEnd, s);
        }
        return s.substring(maxStart, maxEnd + 1);
    }
    
    public void calculateMaxLength(int start, int end, int maxStart, int maxEnd, String s){
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            if (maxEnd - maxStart < end - start) {
                maxStart = start;
                maxEnd = end;
            }
            start--;
            end++;
        }
        this.maxStart = maxStart;
        this.maxEnd = maxEnd;
    }
}