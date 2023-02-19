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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return res;
        q.add(root);
        boolean flag = false;
        while(!q.isEmpty()){
            int k = q.size();
            List<Integer> sublist = new ArrayList<>();
            for(int i = 0; i < k; i++){
                if(q.peek().left != null) q.add(q.peek().left);
                if(q.peek().right != null) q.add(q.peek().right);
                if(flag){
                    // Adding in reverse order by Adding at starting
                    sublist.add(0, q.remove().val);
                }
                else{
                    sublist.add(q.remove().val);
                }
            }
            flag = !flag;
            res.add(sublist);
        }
        return res;
    }
}