class Solution {
    public int helper(TreeNode root, int value) {
        if(root == null) return 0;

        if(root.left == null && root.right == null) return value * 10 + root.val;

        int l = helper(root.left, value * 10 + root.val);
        int r = helper(root.right, value * 10 + root.val);

        return l + r;
    }
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
}