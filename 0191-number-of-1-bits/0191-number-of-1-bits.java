class Solution {
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        return (int) s.chars().filter(c -> c == '1').count();
    }
}