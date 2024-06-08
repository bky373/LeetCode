class Solution {

    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int k = 0;
        int longest = 0;
        int mapVersion = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        while (start + k < s.length()) {
            char curr = s.charAt(start + k);
            int curVersion = charMap.getOrDefault(curr, 0);
            if (curVersion > mapVersion) {
                longest = Math.max(longest, k);
                start++;
                k = 0;
                mapVersion = curVersion;
            } else {
                charMap.put(curr, mapVersion + 1);
                k++;
            }
        }
        longest = Math.max(longest, k);
        return longest;
    }
}