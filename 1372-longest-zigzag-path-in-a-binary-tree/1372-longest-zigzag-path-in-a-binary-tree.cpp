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
    int maxi = 0;
    void helper(TreeNode* root, int dir, int len){
        if(root == NULL) return;
        maxi = max(maxi, len);
        if(dir == 0){
            helper(root->left, dir, 1);
            helper(root->right, 1, len + 1);
        }
        if(dir == 1){
            helper(root->left, 0, len + 1);
            helper(root->right, dir, 1);
        }
    }
    int longestZigZag(TreeNode* root) {
        // direction
        // 0 --> left : 1 --> right
        helper(root->left, 0, 1);
        helper(root->right, 1, 1);
        return maxi;
    }
};