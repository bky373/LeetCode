class Solution {
    Set<List<Integer>> result = new HashSet<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, new ArrayList<Integer>(), 0, target);
        return result.stream().toList();
    }
    
    void backtrack(int[] candidates, List<Integer> combination, int sum, int target) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            List<Integer> comb =  new ArrayList<>(combination);
            comb.sort(Comparator.naturalOrder());
            result.add(comb);
            return;
        }
        
        for (int i=0; i<candidates.length; i++) {
            combination.add(candidates[i]);
            backtrack(candidates, combination, sum + candidates[i], target);
            combination.remove(combination.size() - 1);            
        }
    }
}
