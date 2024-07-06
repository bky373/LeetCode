class Solution {
    boolean[] visited;
    
    public int countComponents(int n, int[][] edges) {
        this.visited = new boolean[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>())
                    .add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>())
                    .add(edge[0]);
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(i)) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            dfs(i, map);
            ans++;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans++;
            }
        }
        return ans;
    }
    
    public void dfs(int k, Map<Integer, List<Integer>> map) {
        if (visited[k]) {
            return;
        }
        visited[k] = true;
        if (!map.containsKey(k)) {
            return;
        }
        List<Integer> values = map.get(k);
        for (int v : values) {
            dfs(v, map);
        }
    }
}