/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return findMax(root, 0);
    }
    
    public int findMax(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        return Math.max(findMax(node.left, depth+1), findMax(node.right, depth+1));
    }
}