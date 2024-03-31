class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x: nums1) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int x: nums2) {
            if (map.containsKey(x)) {
                int v = map.get(x);
                if (v != 0) {
                    map.put(x, --v);
                    list.add(x);
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}