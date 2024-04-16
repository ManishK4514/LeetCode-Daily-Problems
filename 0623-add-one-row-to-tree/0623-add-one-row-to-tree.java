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
    public int heightOfTree(TreeNode root) {
        if(root == null) return 0;

        int l = heightOfTree(root.left);
        int r = heightOfTree(root.right);

        return 1 + Math.max(l, r);
    } 

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int height = 0;

        int maxHeight = heightOfTree(root);

        Queue<TreeNode> lq = new LinkedList<>();

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                TreeNode node = q.remove();

                if(height == maxHeight - 1) lq.add(node);

                if(node.left != null) {
                    if(height == depth - 2) {
                        TreeNode newNode = new TreeNode(val);
                        TreeNode leftNode = node.left;
                        node.left = newNode;
                        newNode.left = leftNode;
                    }
                    q.add(node.left);
                }
                else if(height == depth - 2) node.left = new TreeNode(val);

                if(node.right != null) {
                    if(height == depth - 2) {
                        TreeNode newNode = new TreeNode(val);
                        TreeNode rightNode = node.right;
                        node.right = newNode;
                        newNode.right = rightNode;
                    }
                    q.add(node.right);
                }
                else if(height == depth - 2) node.right = new TreeNode(val);
            }

            height++;
        }

        if(maxHeight < depth) {
            while(!lq.isEmpty()) {
                TreeNode node = lq.remove();
                node.left = new TreeNode(val);
                node.right = new TreeNode(val);
            }
        }

        return root;
    }
}