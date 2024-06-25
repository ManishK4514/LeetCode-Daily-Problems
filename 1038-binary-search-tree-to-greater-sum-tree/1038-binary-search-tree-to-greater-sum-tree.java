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
    public int convertToGst(TreeNode root, int sum) {
        if(root == null) return 0;
        int rootVal = root.val;
        int right = convertToGst(root.right, sum);
        root.val = sum + right + root.val;
        int left = convertToGst(root.left, root.val);
        return rootVal + left + right;
    }
    public TreeNode bstToGst(TreeNode root) {
        convertToGst(root, 0);
        return root;
    }
}