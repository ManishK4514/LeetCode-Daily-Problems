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
    int bottomMost = -1, bottomLeft = -1;
    public void helper(TreeNode root, int bottom) {
        if(root == null) return;

        if(bottom > bottomMost) {
            bottomLeft = root.val;
            bottomMost = bottom;
        }

        helper(root.left, bottom + 1);
        helper(root.right, bottom + 1);
    }
    public int findBottomLeftValue(TreeNode root) {
        helper(root, 1);
        return bottomLeft;
    }
}