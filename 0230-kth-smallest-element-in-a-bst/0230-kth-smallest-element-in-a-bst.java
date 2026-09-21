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
    int ans=-1;
    int curr;
    public void inorder(TreeNode root){
        if(root==null)return ;

        inorder(root.left);
        curr--;
        if(curr==0){
            ans=root.val;
            return;
        }
        if(ans!=-1)return;
        inorder(root.right);

        return ;
    }
    public int kthSmallest(TreeNode root, int k) {
        curr=k;
        inorder(root);
        return ans;
    }
}