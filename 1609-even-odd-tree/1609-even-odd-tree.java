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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            int prevMax = Integer.MIN_VALUE;
            int prevMin = Integer.MAX_VALUE;
            
            for(int i = 0; i < size; i++) {
                TreeNode node = q.remove();

                if(level % 2 == 0) {
                    if(node.val % 2 == 0) return false;
                    if(prevMin != Integer.MAX_VALUE && node.val <= prevMin) return false;
                    prevMin = node.val;
                }
                else {
                    if(node.val % 2 != 0) return false;
                    if(prevMax != Integer.MIN_VALUE && node.val >= prevMax) return false;
                    prevMax = node.val;
                }

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }

            level++;
        }

        return true;
    }
}