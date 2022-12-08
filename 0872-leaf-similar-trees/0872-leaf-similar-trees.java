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
    public void findLeaf(TreeNode root, ArrayList<Integer> res){
        if(root == null) return;
        if(root.left == null && root.right == null) res.add(root.val);
        findLeaf(root.left, res);
        findLeaf(root.right, res);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        findLeaf(root1, arr1);
        findLeaf(root2, arr2);
        return arr1.equals(arr2);
    }
}