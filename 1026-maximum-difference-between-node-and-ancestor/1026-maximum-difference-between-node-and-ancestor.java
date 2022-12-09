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
    public int findMax(TreeNode root, int maxNum, int minNum){
        if(root == null) {
            return maxNum - minNum;
        }
        maxNum = Math.max(maxNum, root.val);
        minNum = Math.min(minNum, root.val);
        return Math.max(findMax(root.left, maxNum, minNum), findMax(root.right, maxNum, minNum));
    }
    public int maxAncestorDiff(TreeNode root) {
        int maxNum = 0, minNum = Integer.MAX_VALUE;
        return findMax(root, maxNum, minNum);
    }
}