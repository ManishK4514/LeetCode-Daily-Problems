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
    TreeNode startNode = new TreeNode(-1);
    public void markParent(TreeNode root, HashMap<TreeNode, TreeNode> parent, int start){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.remove();
                if(node.val == start) startNode = node;
                if(node.left != null) {
                    parent.put(node.left, node);
                    q.add(node.left);
                }
                if(node.right != null) {
                    parent.put(node.right, node);
                    q.add(node.right);
                }
            }
        }
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        markParent(root, parent, start);
        Queue<TreeNode> q = new LinkedList<>();         
        HashSet<TreeNode> vis = new HashSet<>();
        vis.add(startNode); q.add(startNode);
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            steps++;
            for(int i = 0; i < size; i++){
                TreeNode node = q.remove();
                vis.add(node); // marking visited
                if(node.left != null) {
                    if(!vis.contains(node.left)) q.add(node.left);
                }
                if(node.right != null) {
                    if(!vis.contains(node.right)) q.add(node.right);
                }
                if(parent.containsKey(node)) {
                    if(!vis.contains(parent.get(node))) q.add(parent.get(node));
                }
            }
        }
        return steps - 1;
    }
}