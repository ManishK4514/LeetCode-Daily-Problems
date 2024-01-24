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
    public int helper(TreeNode root, int bitmask) {
        if(root == null) return 0;
        
        bitmask ^= (1 << root.val);
        
        if(root.left == null && root.right == null) {
            if((bitmask & (bitmask - 1)) == 0) {
                return 1;
            }
            return 0;
        } 

        int left = helper(root.left, bitmask);
        int right = helper(root.right, bitmask);
        
        return left + right;
    }
    
    public int pseudoPalindromicPaths(TreeNode root) {
        return helper(root, 0);
    }
}