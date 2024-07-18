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

class Pair{
    TreeNode node;
    int dist;

    Pair(TreeNode node, int dist){
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public static void markParent(TreeNode root, HashMap<TreeNode, TreeNode> parent_track){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode current = queue.remove();
                if(current.left != null){
                    parent_track.put(current.left, current);
                    queue.add(current.left);
                }
                if(current.right != null){
                    parent_track.put(current.right, current);
                    queue.add(current.right);
                }
            }
        }
    }
    
    public void helper(TreeNode root, HashSet<TreeNode> leaves){
        if(root == null) return;
        if(root.left == null && root.right == null) leaves.add(root);

        helper(root.left, leaves);
        helper(root.right, leaves);
    }

    public int shortestPath(TreeNode root, HashMap<TreeNode, TreeNode> parent, TreeNode src, int distance, HashSet<TreeNode> leaves){
        Queue<Pair> q = new LinkedList<>();
        HashSet<TreeNode> set = new HashSet<>();
        q.add(new Pair(src, 0));
        set.add(src);

        int count = 0;
        
        while(!q.isEmpty()){
            Pair p = q.remove();
            TreeNode node = p.node;
            int dist = p.dist;
            set.add(node);

            if(dist > 0 && leaves.contains(node)) {
                count++;
            }

            if(dist >= distance) continue;

            if(node.left != null && !set.contains(node.left)){
                q.add(new Pair(node.left, dist + 1));
            }
            if(node.right != null && !set.contains(node.right)){
                q.add(new Pair(node.right, dist + 1));
            }
            if(parent.containsKey(node) && !set.contains(parent.get(node))){
                q.add(new Pair(parent.get(node), dist + 1));
            }
        }
        return count;
    }

    public int countPairs(TreeNode root, int distance) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        markParent(root, parent);
        
        HashSet<TreeNode> leaves = new HashSet<>();
        helper(root, leaves);

        int n = leaves.size(), count = 0;

        for(TreeNode leaf : leaves){
            count += shortestPath(root, parent, leaf, distance, leaves);
        }
    
        return count/2;
    }
}