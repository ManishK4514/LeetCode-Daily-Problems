class Solution {
    public TreeNode helper(List<TreeNode> ls, int l, int r) {
        if(l > r) return null;
        int mid = l + (r - l)/2;
        TreeNode root = ls.get(mid);
        root.left = helper(ls, l, mid - 1);
        root.right = helper(ls, mid + 1, r);
        return root;
    }

    public void inorder(TreeNode root, List<TreeNode> ls) {
        if(root == null) return;
        inorder(root.left, ls);
        ls.add(root);
        inorder(root.right, ls);
    }
    
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> ls = new ArrayList<>();
        inorder(root, ls);
        return helper(ls, 0, ls.size() - 1);
    }
}