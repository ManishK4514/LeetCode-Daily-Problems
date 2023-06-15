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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans = -1, max = Integer.MIN_VALUE, count = 1;
        while(!q.isEmpty()){
            int size = q.size(), sum = 0;
            for(int i = 0; i < size; i++){
                TreeNode curr = q.remove();
                sum += curr.val;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            if(max < sum){
                max = sum;
                ans = count;
            }
            count++;
        }
        return ans;
    }
}