class Solution {
    int maxStart = 0;
    int maxEnd = 0;
    
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            calculateMaxLength(i, i, s);
            calculateMaxLength(i, i+1, s);
        }
        return s.substring(maxStart, maxEnd + 1);
    }
    
        public void calculateMaxLength(int start, int end, String s){
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            if (this.maxEnd - this.maxStart < end - start) {
                this.maxStart = start;
                this.maxEnd = end;
            }
            start--;
            end++;
        }
    }

}