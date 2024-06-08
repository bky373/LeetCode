class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int k = 0;
        int longest = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (start + k < s.length()) {
            char curr = s.charAt(start + k);
            if (map.containsKey(curr)) {
                start++;
                longest = Math.max(longest, k);
                k = 0;
                map = new HashMap<>();
            } else {
                map.put(curr, 1);
                k++;
            }
        }
        longest = Math.max(longest, k);
        return longest;
    }
}