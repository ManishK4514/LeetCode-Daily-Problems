class Solution {
    public void postOrder(TreeNode root, List<Integer> ls) {
        if(root == null) return;

        postOrder(root.left, ls);
        postOrder(root.right, ls);
        
        ls.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        postOrder(root, ls);
        return ls;
    }
}