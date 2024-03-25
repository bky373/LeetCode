class Solution {
    public int firstUniqChar(String s) {
        int len = s.length();
        Map<Character, Integer> counts = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < len; i++) {
            if (counts.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}