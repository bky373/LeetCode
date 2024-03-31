class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int x: nums1) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int k = 0;
        for (int x: nums2) {
            int cnt = map.getOrDefault(x, 0);
            if (cnt > 0) {
                nums1[k++] = x;
                map.put(x, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}