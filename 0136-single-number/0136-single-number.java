class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            var v = map.getOrDefault(x, 0);
            map.put(x, ++v);
        }
        for (int x : nums) {
            if (map.get(x) == 1) {
                return x;
            }
        }
        return -1;
    }
}
