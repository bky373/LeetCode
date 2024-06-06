class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }
        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(freqMap::get));
        for (Integer n : freqMap.keySet()) {
            pq.add(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return IntStream.range(0, k).map(i -> pq.poll()).toArray();
    }
}