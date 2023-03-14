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
    int ans = 0;
    public void inorder(TreeNode root, int num){
        if(root == null) return;
        if(root.left == null && root.right == null){
            ans += (num * 10 + root.val);
            return;
        }
        inorder(root.left, num * 10 + root.val);
        inorder(root.right, num * 10 + root.val);
    }
    public int sumNumbers(TreeNode root) {
        inorder(root, 0);
        return ans;
    }
}