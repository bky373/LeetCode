/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 *
 * Approach 1: Sliding Window
 * - TC: O(n), where n is the length of the input string s.
 * - SC: O(1), because the counter map will contain at most 26 entries regardless of the length of the input string.
 *
 * 변경할 숫자 = 부분문자열의 길이 - 최대 반복 문자 수 <= k, 종료 인덱스 증가
 * 변경할 숫자 = 부분문자열의 길이 - 최대 반복 문자 수 > k, 시작 인덱스 증가 (변경할 문자를 줄여야 하기 때문에)
 * 예) k = 1

 v
 AABABBA
 ^
 반복 문자:
 A: 1 (최대)
 1 - 1 = 0 <= 1, 종료 인덱스 증가, 최대 부분문자열 길이=1

 v
 AABABBA
 ^
 반복 문자:
 A: 2 (최대)
 2 - 2 = 0 <= 1, 종료 인덱스 증가, 최대 부분문자열 길이=2

 v
 AABABBA
 ^
 반복 문자:
 A: 2 (최대)
 B: 1
 3 - 2 = 1 <= 1, 종료 인덱스 증가, 최대 부분문자열 길이=3

 v
 AABABBA
 ^
 반복 문자:
 A: 3 (최대)
 B: 1
 4 - 3 = 1 <= 1, 종료 인덱스 증가, 최대 부분문자열 길이=4

 v
 AABABBA
 ^
 반복 문자:
 A: 3 (최대)
 B: 2
 5 - 3 = 2 > 1, 시작 인덱스 증가, 최대 부분문자열 길이=4

 v
 AABABBA
 ^
 반복 문자:
 A: 2 (최대)
 B: 2
 4 - 2 = 2 > 1, 시작 인덱스 증가, 최대 부분문자열 길이=4

 v
 AABABBA
 ^
 반복 문자:
 A: 1
 B: 2 (최대)
 3 - 2 = 1 <= 1, 종료 인덱스 증가, 최대 부분문자열 길이=4

 v
 AABABBA
 ^
 반복 문자:
 A: 1
 B: 3 (최대)
 4 - 3 = 1 <= 1, 종료 인덱스 증가, 최대 부분문자열 길이=4

 v
 AABABBA
 ^
 반복 문자:
 A: 2
 B: 3 (최대)
 5 - 3 = 2 > 1, 시작 인덱스 증가, 최대 부분문자열 길이=4

 v
 AABABBA
 ^
 반복 문자:
 A: 2
 B: 2 (최대)
 4 - 2 = 2 > 1, 시작 인덱스 증가, 최대 부분문자열 길이=4

 v
 AABABBA
 ^
 반복 문자:
 A: 1
 B: 2 (최대)
 3 - 2 = 1 <= 1, 종료 인덱스 증가(범위 초과하여 종료), 최대 부분문자열 길이=4
 */
class Solution {
    public int characterReplacement(String s, int k) {
        int answer = 0;

        int start = 0;
        int end = 0;

        Map<Character, Integer> counter = new HashMap<>();

        while (end < s.length()) {
            counter.merge(s.charAt(end), 1, Integer::sum);
            int maxRepeat = Collections.max(counter.values());

            while (end - start + 1 - maxRepeat > k) {
                counter.computeIfPresent(s.charAt(start), (key, v) -> v - 1);
                start++;
            }

            answer = Math.max(answer, end - start + 1);
            end++;
        }
        return answer;
    }
}

/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 *
 * Approach 2: Improved Sliding Window
 * - TC: O(n), where n is the length of the input string s. This is because we iterate through the string only once using two pointers, start and end.
 * - SC: O(1), because the size of array is fixed 26 regardless of the length of the input string.
 */
class Solution {
    public int characterReplacement(String s, int k) {
        int[] alp = new int[26];
        int start = 0;
        int maxCnt = 0;
        int maxLen = 0;
        for (int end = 0; end < s.length(); end++) {
            maxCnt = Math.max(maxCnt, ++alp[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCnt > k) {
                alp[s.charAt(start) - 'A']--;
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
