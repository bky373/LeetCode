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
/**
 * 시간 복잡도: O(N^(T/M + 1))
 * - 여기서 N은 후보의 수, T는 목표 값, M은 후보들 중 최소값입니다.
 * - 백트래킹 과정은 N진 트리의 깊이 우선 탐색(DFS)으로 볼 수 있습니다.
 * - 각 노드에서 처리 시간은 일정하지만, 리프 노드에서는 조합을 복사하는 데 선형 시간이 걸릴 수 있습니다.
 * - 트리의 최대 깊이는 T/M입니다 (가장 작은 원소를 계속 더하는 경우).
 * - N진 트리에서 높이가 T/M일 때 최대 노드 수는 N^(T/M + 1)입니다.
 * - 실제로는 레벨이 깊어질수록 선택 가능한 노드 수가 줄어들어 이보다 적을 것입니다.
 * 공간 복잡도: O(T/M)
 * - 재귀 호출로 인한 함수 호출 스택이 최대 T/M만큼 쌓일 수 있습니다.
 * - 또한 조합을 저장하는 데 최대 O(T/M) 공간이 필요합니다.
 * - 따라서 전체 공간 복잡도는 O(T/M)입니다.
 */