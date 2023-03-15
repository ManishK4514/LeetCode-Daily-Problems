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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = false;
        while(!q.isEmpty()){
            int size = q.size();            
            for(int i = 0; i < size; i++){
                TreeNode curr = q.remove();
                if(flag && (curr.left != null || curr.right != null)) return false;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                if(curr.left == null || curr.right == null) flag = true;
                if(flag && curr.left == null && curr.right != null) return false;
            }
        }
        return true;
    }
}