/**
 * https://leetcode.com/problems/container-with-most-water/
 *
 * Two Pointer Approach
 * TC: O(n), where n is the length of height.
 * SC: O(1)
 */
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, (right - left) * minHeight);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
