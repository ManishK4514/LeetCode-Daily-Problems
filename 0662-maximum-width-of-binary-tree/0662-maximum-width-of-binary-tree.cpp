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
    int widthOfBinaryTree(TreeNode* root) {
        root->val = 0;
        long long maxi = 0;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            long long first = 0, last = 0;
            for(int i = 0; i < size; i++){
                TreeNode* curr = q.front();
                q.pop();
                if(i == 0) first = curr->val;
                if(i == size - 1) last = curr->val;
                if(curr->left != NULL) {
                    q.push(curr->left);
                    curr->left->val = 2LL * curr->val + 1;
                }
                if(curr->right != NULL) {
                    q.push(curr->right);
                    curr->right->val = 2LL * curr->val + 2;
                }
            }
            maxi = max(maxi, last - first + 1);
        }
        return maxi;
    }
};