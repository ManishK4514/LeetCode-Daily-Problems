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
    int maxSum;    
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maximumPath(root);
        return maxSum;
    }
    public int maximumPath(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0, maximumPath(root.left));
        int right = Math.max(0, maximumPath(root.right));
        maxSum = Math.max(maxSum, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}