class Solution {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        int startingIndex = 0;
        
        this.backtrack(candidates, new ArrayList<Integer>(), startingIndex, target, results);
        return results;
    }
    
    protected void backtrack(int[] candidates, List<Integer> comb, int start, int remain, List<List<Integer>> results) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            results.add(new ArrayList<>(comb));
            return;
        }
        
        for (int i=start; i<candidates.length; i++) {
            comb.add(candidates[i]);
            backtrack(candidates, comb, i, remain - candidates[i], results);
            comb.removeLast(); 
        }
    }
}
