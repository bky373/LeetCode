// https://leetcode.com/problems/group-anagrams/

/**
 * Approach 1: Categorize by Sorted String
 *
 * TC: O(n * klogk), where n is the length of strs, and k is the maximum length of a string in strs.
 * SC: O(n * k), the total elements stored in answer.
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        for (String word : strs) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            anagramGroups.computeIfAbsent(new String(arr), k -> new ArrayList<>())
                    .add(word);
        }
        return new ArrayList(anagramGroups.values());
    }
}

/**
 * Approach 2: Categorize by Count
 *
 * TC: O(n * k), where n is the length of strs, and k is the maximum length of a string in strs.
 * SC: O(n * k), the total elements stored in answer.
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        int[] counts = new int[26];

        for (String word : strs) {
            Arrays.fill(counts, 0);
            char[] arr = word.toCharArray();
            for (char c : arr) {
                counts[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(counts[i]);
            }
            anagramGroups.computeIfAbsent(sb.toString(), k -> new ArrayList<>())
                    .add(word);
        }
        return new ArrayList(anagramGroups.values());
    }
}
