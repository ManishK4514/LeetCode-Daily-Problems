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
    public int[] dfs(TreeNode root) {
        if(root == null) return new int[]{0, 0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int[] curr = new int[]{left[0] + right[0], left[1] + right[1]};

        curr[0] += root.val - 1;
        curr[1] += Math.abs(curr[0]);

        return curr;
    } 

    public int distributeCoins(TreeNode root) {
        return dfs(root)[1];
    }
}