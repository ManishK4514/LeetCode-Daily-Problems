class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        map.put(root, root.val);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            int totalSum = 0;

            Queue<TreeNode> qq = new LinkedList<>();

            for(int i = 0; i < size; i++) {
                TreeNode parent = q.remove();
                qq.add(parent);
                totalSum += parent.val;
                int currSum = 0;

                if(parent.left != null) {
                    currSum += parent.left.val;
                    q.add(parent.left);
                }
                if(parent.right != null) {
                    currSum += parent.right.val;
                    q.add(parent.right);
                }
                if(parent.left != null) map.put(parent.left, currSum);
                if(parent.right != null) map.put(parent.right, currSum);
            }

            for(int i = 0; i < size; i++) {
                TreeNode parent = qq.remove();
                parent.val = totalSum - map.get(parent);
            }
        }

        return root;
    }
}