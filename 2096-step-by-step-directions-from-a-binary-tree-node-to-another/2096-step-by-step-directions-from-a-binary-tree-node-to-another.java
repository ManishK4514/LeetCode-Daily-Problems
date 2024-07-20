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
    public void markParent(TreeNode root, HashMap<TreeNode, TreeNode> parent){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.remove();
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

    public TreeNode findNode(TreeNode root, int startValue){
        if(root == null) return null;
        if(root.val == startValue) return root;
        TreeNode left = findNode(root.left, startValue);
        TreeNode right = findNode(root.right, startValue);
        return left == null ? right : left;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        // base case
        if(root == null || root == p | root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null) return right;
        else if(right == null) return left;
        else return root;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        markParent(root, parent);
        
        TreeNode src = findNode(root, startValue);
        TreeNode dst = findNode(root, destValue);

        TreeNode lca = lowestCommonAncestor(root, src, dst);
        
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();

        while(src != lca){
            src = parent.get(src);
            left.append("U");
        }
        
        while(dst != lca){
            TreeNode par = parent.get(dst);
            if(par.left == dst) right.append("L");
            else right.append("R");
            dst = par;
        }

        return left.append(right.reverse().toString()).toString();
    }
}
