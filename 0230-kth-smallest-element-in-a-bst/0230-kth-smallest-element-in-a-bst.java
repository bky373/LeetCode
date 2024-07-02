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
    List<Integer> inorderList = new ArrayList<>();
    
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return inorderList.get(k - 1);
    }
    
    public void inorder(TreeNode cur) {
        if (cur == null) {
            return;
        }
        inorder(cur.left);
        inorderList.add(cur.val);
        inorder(cur.right);
    }
}
