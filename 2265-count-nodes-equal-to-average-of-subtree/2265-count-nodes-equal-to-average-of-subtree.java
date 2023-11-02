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
    int count = 0;
    public int[] helper(TreeNode root) {
        if(root == null) return new int[]{0, 0};
        int[] left = helper(root.left);
        int[] right = helper(root.right);

        int[] ans = new int[2];
        ans[0] = root.val + left[0] + right[0];
        ans[1] = 1 + left[1] + right[1];

        if(ans[0]/ans[1] == root.val) count++;
        
        return ans;        
    }
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return count;
    }
}