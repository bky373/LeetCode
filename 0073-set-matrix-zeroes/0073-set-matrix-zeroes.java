/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 *
 * Approach 1.
 * - TC: O(m * n * (m+n)), where m is the number of rows and n is the number of columns.
 * - SC: O(m*n)
 */
class Solution {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                if (matrix[r][c] == 0 && !visited[r][c]) {
                    visited[r][c] = true;
                    for (int k = 0; k < r; ++k) {
                        if (!visited[k][c] && matrix[k][c] != 0) {
                            matrix[k][c] = 0;
                            visited[k][c] = true;
                        }
                    }
                    for (int k = r + 1; k < m; ++k) {
                        if (!visited[k][c] && matrix[k][c] != 0) {
                            matrix[k][c] = 0;
                            visited[k][c] = true;
                        }
                    }
                    for (int k = 0; k < c; ++k) {
                        if (!visited[r][k] && matrix[r][k] != 0) {
                            matrix[r][k] = 0;
                            visited[r][k] = true;
                        }
                    }
                    for (int k = c + 1; k < n; ++k) {
                        if (!visited[r][k] && matrix[r][k] != 0) {
                            matrix[r][k] = 0;
                            visited[r][k] = true;
                        }
                    }
                }
            }
        }
    }
}

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 *
 * Approach 2. Additional Memory Approach
 * - TC: O(m * n), where m is the number of rows and n is the number of columns.
 * - SC: O(m + n)
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();

        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                if (matrix[r][c] == 0) {
                    rows.add(r);
                    cols.add(c);
                }
            }
        }

        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                if (rows.contains(r) || cols.contains(c)) {
                    matrix[r][c] = 0;
                }
            }
        }
    }
}

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 *
 * Approach 3. O(1) Space, Efficient Solution
 * - TC: O(m * n), where m is the number of rows and n is the number of columns.
 * - SC: O(1)
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowHasZero = false; // 첫 번째 행이 0으로 바뀌어야 하는지 확인 (나머지 행을 0으로 만드는 데 사용되기 때문에 따로 처리)
        boolean firstColHasZero = false; // 첫 번째 열이 0으로 바뀌어야 하는지 확인 (나머지 열을 0으로 만드는 데 사용되기 때문에 따로 처리)

        int m = matrix.length;
        int n = matrix[0].length;

        // 첫 번째 열에 0이 있는지 확인
        for (int r = 0; r < m; ++r) {
            if (matrix[r][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // 첫 번째 행에 0이 있는지 확인
        for (int c = 0; c < n; ++c) {
            if (matrix[0][c] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // 나머지 행과 열을 순회하면서, 0이 발견되면 첫 번째 행과 열에 그 위치를 기록
        // 첫 번째 행과 열은 나머지 셀들을 0으로 만들기 위한 '메모리' 역할을 함
        for (int r = 1; r < m; ++r) {
            for (int c = 1; c < n; ++c) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        // 기록된 정보를 바탕으로 나머지 셀을 0으로 변환
        for (int r = 1; r < m; ++r) {
            for (int c = 1; c < n; ++c) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        // 첫 번째 열 처리: 최초에 0을 가지고 있었다면, 그 열 전체를 0으로 설정
        if (firstColHasZero) {
            for (int r = 0; r < m; ++r) {
                matrix[r][0] = 0;
            }
        }

        // 첫 번째 행 처리: 최초에 0을 가지고 있었다면, 그 행 전체를 0으로 설정
        if (firstRowHasZero) {
            for (int c = 0; c < n; ++c) {
                matrix[0][c] = 0;
            }
        }
    }
}
