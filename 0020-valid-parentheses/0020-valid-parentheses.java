/**
 * - 문제: https://leetcode.com/problems/valid-parentheses/
 * - TC: O(n), where n is the length of string.
 * - SC: O(1)
 */
class Solution {

    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = Map.of('(', ')', '{', '}', '[', ']');
        Stack<Character> openSt = new Stack<>();
        for (char c : s.toCharArray()) {
            if (pairs.containsKey(c)) {
                openSt.push(c);
            } else {
                if (openSt.isEmpty()) {
                    return false;
                }
                if (c != pairs.get(openSt.pop())) {
                    return false;
                }
            }
        }
        return openSt.isEmpty();
    }
}
