/**
 * https://leetcode.com/problems/spiral-matrix/
 *
 * Approach 1: Set Up Boundaries
 * - TC: O(m*n), where m is the number of rows and n is the number of columns.
 * - SC: O(1)
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0;
        int left = 0;
        int right = cols - 1;
        int bottom = rows - 1;

        while (result.size() < rows * cols) {
            // Traverse from left to right.
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            // Traverse downwards.
            for (int row = top + 1; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            // Make sure we are now on a different row.
            if (top != bottom) {
                // Traverse from right to left.
                for (int col = right - 1; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
            }
            // Make sure we are now on a different column.
            if (left != right) {
                for (int row = bottom - 1; row > top; row--) {
                    result.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }
}

/**
 * https://leetcode.com/problems/spiral-matrix/
 *
 * Approach 2: Mark Visited Elements
 * - TC: O(m*n), where m is the number of rows and n is the number of columns.
 * - SC: O(1)
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int VISITED = 101;
        int rows = matrix.length;
        int cols = matrix[0].length;
        // A clockwise direction that we will move: right, down, left, up.
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // Initial direction: moving right.
        int currentDirection = 0;
        // The number of times we change the direction.
        int changeDirection = 0;
        // Current place that we are at is (row, col).
        int row = 0;
        int col = 0;
        // Store the first element and mark it as visited.
        List<Integer> result = new ArrayList<>();
        result.add(matrix[0][0]);
        matrix[0][0] = VISITED;
        while (changeDirection < 2) {
            while (
                    row + directions[currentDirection][0] >= 0 &&
                            row + directions[currentDirection][0] < rows &&
                            col + directions[currentDirection][1] >= 0 &&
                            col + directions[currentDirection][1] < cols &&
                            matrix[row + directions[currentDirection][0]][col + directions[currentDirection][1]] != VISITED
            ) {
                changeDirection = 0;
                row = row + directions[currentDirection][0];
                col = col + directions[currentDirection][1];
                result.add(matrix[row][col]);
                matrix[row][col] = VISITED;
            }
            currentDirection = (currentDirection + 1) % 4;
            changeDirection++;
        }
        return result;
    }
}

/**
 * https://leetcode.com/problems/spiral-matrix/
 *
 * Approach 3: Improve Approach 1.
 * - TC: O(m*n), where m is the number of rows and n is the number of columns.
 * - SC: O(1)
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int direction = 1;
        int row = 0;
        int col = -1;
        List<Integer> result = new ArrayList<>();

        while (m * n > 0) {
            // Move horizontally
            for (int i = 0; i < n; i++) {
                col += direction;
                result.add(matrix[row][col]);
            }
            m--;

            // Move vertically
            for (int i = 0; i < m; i++) {
                row += direction;
                result.add(matrix[row][col]);
            }
            n--;

            // Flip direction
            direction *= -1;
        }

        return result;
    }
}

/**
 * https://leetcode.com/problems/spiral-matrix/
 *
 * Approach 4: Mark Visited Elements 2
 * - TC: O(m*n), where m is the number of rows and n is the number of columns.
 * - SC: O(1)
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int row = 0;
        int col = 0;
        int dirIndex = 0;
        List<Integer> result = new ArrayList<>();
        int total = m * n;

        while (result.size() < total) {
            result.add(matrix[row][col]);

            matrix[row][col] = 101;

            int newRow = row + dir[dirIndex][0];
            int newCol = col + dir[dirIndex][1];

            if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || matrix[newRow][newCol] == 101) {
                dirIndex = (dirIndex + 1) % dir.length;
                newRow = row + dir[dirIndex][0];
                newCol = col + dir[dirIndex][1];
            }
            row = newRow;
            col = newCol;
        }
        return result;
    }
}
