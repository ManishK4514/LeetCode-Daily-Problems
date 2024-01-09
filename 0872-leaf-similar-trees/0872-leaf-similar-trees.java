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
    boolean isMatching = false;
    boolean isSimilar = true;
    int idx = 0;
    public void preorder(TreeNode root, ArrayList<Integer> ls) {
        if(root == null) return;
        
        if(isMatching && root.left == null && root.right == null) {
            if(idx >= ls.size()) isSimilar = false;
            else if(ls.get(idx++) != root.val) isSimilar = false;
        }
        else if(root.left == null && root.right == null) ls.add(root.val);

        preorder(root.left, ls);
        preorder(root.right, ls);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> ls = new ArrayList<>();
        preorder(root1, ls);
        isMatching = true;
        preorder(root2, ls);
        return isSimilar && idx == ls.size();
    }
}