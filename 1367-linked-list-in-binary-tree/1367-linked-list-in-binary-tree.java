class Solution {
    private boolean doesPathExist(ListNode head, TreeNode root) {
        if (head == null) return true;
        
        if (root == null || root.val != head.val) return false;

        return doesPathExist(head.next, root.left) || doesPathExist(head.next, root.right);
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;

        return doesPathExist(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
}
