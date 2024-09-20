/**
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * Approach 1. BFS
 * - TC: O(m*n), where m is the number of rows and n is the number of columns.
 * - TC: O(m*n), where m is the number of rows and n is the number of columns.
 */
class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int numIslands(char[][] grid) {
        int answer = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    bfs(i, j, grid);
                    ++answer;
                }
            }
        }

        return answer;
    }

    private void bfs(int i, int j, char[][] grid) {
        Queue<Integer> que = new LinkedList<>();
        que.add(i);
        que.add(j);
        grid[i][j] = '0';
        while (!que.isEmpty()) {
            int row = que.poll();
            int col = que.poll();

            for (int k = 0; k < 4; ++k) {
                int newRow = row + directions[k][0];
                int newCol = col + directions[k][1];

                if (newRow < 0 || newRow >= grid.length ||
                        newCol < 0 || newCol >= grid[0].length || grid[newRow][newCol] == '0') {
                    continue;
                }

                grid[newRow][newCol] = '0';
                que.add(newRow);
                que.add(newCol);
            }
        }
    }
}


/**
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * Approach 2. BFS-2
 * - TC: O(m*n), where m is the number of rows and n is the number of columns.
 * - SC: O(min(m*n)), because in worst case where the grid is filled with lands, the size of queue can grow up to min(m,n).
 */
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int numOfIslands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++numOfIslands;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;

                        if (0 <= row - 1 && grid[row - 1][col] == '1') {
                            neighbors.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            neighbors.add((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        if (0 <= col - 1 && grid[row][col - 1] == '1') {
                            neighbors.add(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            neighbors.add(row * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return numOfIslands;
    }
}

/**
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * Approach 3. DFS
 * - TC: O(m*n), where m is the number of rows and n is the number of columns.
 * - SC: worst case O(m×n) in case that the grid map is filled with lands where DFS goes by m×n deep.
 */
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int answer = 0;
        for (int r = 0; r < grid.length; ++r) {
            for (int c = 0; c < grid[0].length; ++c) {
                if (grid[r][c] == '1') {
                    ++answer;
                    dfs(grid, r, c);
                }
            }
        }
        return answer;
    }

    private void dfs(char[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;

        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}


/**
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * Approach 4. Union Find (aka Disjoint Set)
 * - TC: O(m*n), where m is the number of rows and n is the number of columns.
 * Note that Union operation takes essentially constant time when UnionFind is implemented with both path compression and union by rank.
 * - SC: O(M×N) as required by UnionFind data structure.
 */
class Solution {
    class UnionFind {
        int count; // # of connected components
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int r = 0; r < m; ++r) {
                for (int c = 0; c < n; ++c) {
                    if (grid[r][c] == '1') {
                        parent[r * n + c] = r * n + c;
                        ++count;
                    }
                    rank[r * n + c] = 0;
                }
            }
        }

        public int find(int i) { // path compression
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int x, int y) { // union with rank
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx]++;
                }
                --count;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int answer = 0;
        UnionFind uf = new UnionFind(grid);
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                        uf.union(r * nc + c, (r - 1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r + 1][c] == '1') {
                        uf.union(r * nc + c, (r + 1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                        uf.union(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1 < nc && grid[r][c + 1] == '1') {
                        uf.union(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }
        return uf.getCount();
    }
}
