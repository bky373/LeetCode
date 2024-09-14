https://leetcode.com/problems/group-anagrams/
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
 * TC: O(n * klogk), where n is the length of strs, and k is the maximum length of a string in strs.
 * SC: O(n * k), the total elements stored in answer.
 */
