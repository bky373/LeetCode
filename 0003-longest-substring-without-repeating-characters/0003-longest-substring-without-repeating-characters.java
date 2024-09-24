/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Approach 1. Brute Force (Time Limit Exceeded)
 * - TC: O(n^3), where n is the length of s.
 * - SC: O(min(m,n)), where m is the size of the charset/alphabet and n is the length of s(upper bound).
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int longest = 1;
        for (int i = 0; i < s.length(); ++i) {
            for (int j = i; j < s.length(); ++j) {
                if (checkRepetition(s, i, j)) {
                    longest = Math.max(longest, j - i + 1);
                }
            }
        }
        return longest;
    }

    private boolean checkRepetition(String s, int start, int end) {
        Set<Character> chars = new HashSet<>();

        for (int i = start; i <= end; ++i) {
            if (chars.contains(s.charAt(i))) {
                return false;
            }
            chars.add(s.charAt(i));
        }
        return true;
    }
}

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Approach 2. Version Comparing
 * - TC: O(n), where n is the length of s.
 * - SC: O(min(m,n)), where m is the size of the charset/alphabet and n is the length of s(upper bound).
 */
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
        return Math.max(longest, k);
    }
}

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Approach 3-1. Sliding Window
 * [슬라이딩 윈도우] 핵심 아이디어.
 * - 부분 문자열에 중복 문자가 없다면, 종료 포인터를 앞으로 움직여 부분 문자열을 늘린다.
 * - 부분 문자열에 중복 문자가 있다면, 시작 포인터를 앞으로 움직여 부분 문자열을 줄인다.
 * - TC: O(2n) = O(n). In the worst case each character will be visited twice by left and right.
 * - SC: O(min(m,n)), where m is the size of the charset/alphabet and n is the length of s(upper bound).
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> chars = new HashMap<>();
        int left = 0;
        int right = 0;

        int result = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars.put(r, chars.getOrDefault(r, 0) + 1);

            while (chars.get(r) > 1) {
                char l = s.charAt(left);
                chars.put(l, chars.get(l) - 1);
                ++left;
            }

            result = Math.max(result, right - left + 1);
            ++right;
        }
        return result;
    }
}

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Approach 3-2. Sliding Window
 * [슬라이딩 윈도우] 핵심 아이디어.
 * - 부분 문자열에 중복 문자가 없다면, 종료 포인터를 앞으로 움직여 부분 문자열을 늘린다.
 * - 부분 문자열에 중복 문자가 있다면, 시작 포인터를 앞으로 움직여 부분 문자열을 줄인다.
 * - TC: O(2n) = O(n). In the worst case each character will be visited twice by left and right.
 * - SC: O(min(m,n)), where m is the size of the charset/alphabet and n is the length of s(upper bound).
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> chars = new HashSet<>();
        int start = 0;
        int end = 0;
        int result = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (chars.contains(c)) {
                chars.remove(s.charAt(start));
                ++start;
            } else {
                chars.add(c);
                result = Math.max(result, end - start + 1);
                ++end;
            }
        }
        return result;
    }
}

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Approach 4. Sliding Window Optimized
 * - TC: O(n), where n is the length of s.
 * - SC: O(min(m,n)), where m is the size of the charset/alphabet and n is the length of s(upper bound).
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int start = 0;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (start <= map.get(c)) {
                    start = map.get(c) + 1;
                }
            }
            result = Math.max(result, i - start + 1);
            map.put(c, i);
        }
        return result;
    }
}
