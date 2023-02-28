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
    public String helper(TreeNode root, HashMap<String, Integer> map, ArrayList<TreeNode> ans){
        if(root == null) return "";
        String curr = root.val + "," + helper(root.left, map, ans) + "," + helper(root.right, map, ans);
        map.put(curr, map.getOrDefault(curr, 0) + 1);
        if(map.get(curr) == 2) ans.add(root);
        return curr;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<TreeNode> ans = new ArrayList<>();
        helper(root, map, ans);
        // System.out.println(map);
        return ans;
    }
}