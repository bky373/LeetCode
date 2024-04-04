class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0, j = 0, firstMatch = -1;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                firstMatch = i;
                i++;
                j++;
            } else {
                firstMatch = -1;
                i = i + 1 - j;
                j = 0;
            }
        }
        if (firstMatch == -1 || j != needle.length()) {
           return -1;
        }
        return firstMatch - (needle.length() - 1);
    }
}
