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
    int totalNodes;
    int countNodes(TreeNode* root){
        if(root == NULL) return 0;
        return 1 + countNodes(root->left) + countNodes(root->right);
    }
    bool helper(TreeNode* root, int idx){
        if(root == NULL) return true;
        if(idx > totalNodes) return false;
        return helper(root->left, 2 * idx) && helper(root->right, 2 * idx + 1);
    }
    bool isCompleteTree(TreeNode* root) {
        totalNodes = countNodes(root);
        return helper(root, 1);
    }
};