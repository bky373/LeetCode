/**
 * https://leetcode.com/problems/unique-paths/
 *
 * Approach 1-1. Dynamic Programming
 * 점화식: dp[i,j] = dp[i-1, j] + dp[i, j-1]
 * - TC: O(m*n), where m is the number of rows and n is the number of columns.
 * - SC: O(m*n), where m is the number of rows and n is the number of columns.
 */
class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }
        int[][] dp = new int[m][n];
        for (int i = 1; i < m; ++i) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; ++j) {
            dp[0][j] = 1;
        }
        for (int r = 1; r < m; ++r) {
            for (int c = 1; c < n; ++c) {
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}

/**
 * https://leetcode.com/problems/unique-paths/
 *
 * Approach 2. Improved Dynamic Programming
 * 점화식: dp[i,j] = dp[i-1, j] + dp[i, j-1]
 * - TC: O(m*n), where m is the number of rows and n is the number of columns.
 * - SC: O(n)
 */
class Solution {
    public int uniquePaths(int m, int n) {
        // 1차원 배열 dp를 생성하고, 크기는 n으로 설정합니다.
        // 이 배열은 현재 행에서 각 열까지 도달하는 경로의 수를 저장합니다.
        int[] dp = new int[n];

        // 첫 번째 행에서는 모든 열까지 도달하는 방법이 1가지 뿐이므로 배열을 모두 1로 초기화합니다.
        Arrays.fill(dp, 1);

        // 두 번째 행부터 마지막 행까지 반복합니다.
        for (int r = 1; r < m; ++r) {
            // 두 번째 열부터 마지막 열까지 반복합니다.
            for (int c = 1; c < n; ++c) {
                // dp[c]는 현재 위치까지 도달하는 경로의 수를 나타냅니다.
                // 이전 열(dp[c-1])에서 현재 열로 오는 경우를 더해줍니다.
                dp[c] += dp[c - 1];
            }
        }

        // 배열의 마지막 요소 dp[n-1]는 오른쪽 아래 모서리에 도달하는 경로의 수입니다.
        return dp[n - 1];
    }
}
