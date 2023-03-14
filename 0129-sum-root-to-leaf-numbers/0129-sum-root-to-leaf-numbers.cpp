/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int preorder(TreeNode* root, int num){
        if(root == NULL) return 0;
        if(root->left == NULL && root->right == NULL) return num * 10 + root->val;
        int l = preorder(root->left, num * 10 + root->val);
        int r = preorder(root->right, num * 10 + root->val);
        return l + r;
    }
    int sumNumbers(TreeNode* root) {
        return preorder(root, 0);
    }
};