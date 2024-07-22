class Solution {
    public int uniquePaths(int m, int n) {
        int[] upper = new int[n];
        
        Arrays.fill(upper, 1);
        
        for (int i = 1; i < m; i++) {
            int left = 1;
            for (int j = 1; j < n; j++) {
                left += upper[j];
                upper[j] = left;
            }
        }
        
        return upper[n - 1];
    }
}