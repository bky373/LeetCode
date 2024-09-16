/**
 * https://leetcode.com/problems/word-break/
 *
 * Approach 1: Breadth-First Search
 * TC: O(n^2 * m), where n is the length of the input string s and m is the length of the substring of s.
 * SC: O(n + k), where n is the space for the queue and boolean array and k is for the wordDict.
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> baseWords = new HashSet<>(wordDict);
        boolean[] seen = new boolean[s.length() + 1];
        Queue<Integer> que = new LinkedList<>();

        que.add(0);
        while (!que.isEmpty()) {
            int start = que.remove();
            if (start == s.length()) {
                return true;
            }
            for (int end = start + 1; end <= s.length(); ++end) {
                if (seen[end]) {
                    continue;
                }
                if (baseWords.contains(s.substring(start, end))) {
                    que.add(end);
                    seen[end] = true;
                }
            }
        }
        return false;
    }
}

/**
 * Approach 2: Top-Down Dynamic Programming
 * dp(i) = any(s[i - word.length: i]==word && dp(i - word.length))
 * - TC: O(n * m * k), where n is the length of s, m is the length of wordDict, and k is the average length of the words in wordDict.
 * - SC: O(n), where n is the length of s. This is because we use a memoization array of size n.
 */
class Solution {
    private String s;
    private List<String> wordDict;
    private int[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
        this.memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dp(s.length() - 1);
    }

    private boolean dp(int i) {
        if (i < 0) {
            return true;
        }
        if (memo[i] != -1) {
            return memo[i] == 1;
        }
        for (String word : wordDict) {
            if (i - word.length() + 1 < 0) {
                continue;
            }
            if (s.substring(i - word.length() + 1, i + 1).equals(word) &&
                    dp(i - word.length())
            ) {
                memo[i] = 1;
                return true;
            }
        }
        memo[i] = 0;
        return false;
    }
}

/**
 * Approach 3: Bottom-Up Dynamic Programming
 * dp(i) = any(s[i - word.length: i]==word && dp(i - word.length))
 * - TC: O(n * m * k), where n is the length of s, m is the length of wordDict, and k is the average length of the words in wordDict.
 * - SC: O(n), where n is the length of s. This is because we use a memoization array of size n.
 */
class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (String word: wordDict) {
                if (i >= word.length() && dp[i - word.length()]) {
                    if (s.substring(i - word.length(), i).equals(word)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}
