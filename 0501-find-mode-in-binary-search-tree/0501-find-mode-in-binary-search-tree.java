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
    int max = 0;
    public void inorder(TreeNode root, HashMap<Integer, Integer> map) {
        if(root == null) return;
        inorder(root.left, map);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        max = Math.max(max, map.get(root.val));
        inorder(root.right, map);
    }
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        inorder(root, map);
        int cnt = 0, idx = 0; 
        for(int key : map.keySet()) if(map.get(key) == max) cnt++;
        int[] ans = new int[cnt];
        for(int key : map.keySet()) {
            if(map.get(key) == max) ans[idx++] = key;
        }
        
        return ans;
    }
}