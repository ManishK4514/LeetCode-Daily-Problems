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
    long ans = 0, totalSum = 0, mod = 1000000007;
    public long find(TreeNode root){
        if(root == null) return 0;        
        long sum = root.val + find(root.left) + find(root.right); 
        ans = Math.max(ans, (totalSum - sum) * sum);
        return sum;
    }
    public int maxProduct(TreeNode root) {
        totalSum = find(root);
        find(root);
        return (int)(ans%mod);
    }
}