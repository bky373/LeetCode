class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num: nums) {
            if (counts.containsKey(num)) {
                return true;
            }
            counts.put(num, 0);
        }
        return false;
    }
}