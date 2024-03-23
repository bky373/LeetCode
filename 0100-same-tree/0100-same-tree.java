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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pwait = new LinkedList<>();
        Queue<TreeNode> qwait = new LinkedList<>();

        pwait.add(p);
        qwait.add(q);

        while (!pwait.isEmpty()) {
            TreeNode pcur = pwait.poll();
            TreeNode qcur = qwait.poll();

            if (pcur == null && qcur == null) {
                continue;
            }
            if (pcur == null || qcur == null) {
                return false;
            }
            if (pcur.val != qcur.val) {
                return false;
            }
            pwait.add(pcur.left);
            qwait.add(qcur.left);
            pwait.add(pcur.right);
            qwait.add(qcur.right);
        }
        return true;
    }
}