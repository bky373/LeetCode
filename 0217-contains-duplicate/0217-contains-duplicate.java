class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int n : nums) {
            if (map.containsKey(n)) {
                return true;
            } else {
                map.put(n, 0);
            }
        }
        return false;
    }
}