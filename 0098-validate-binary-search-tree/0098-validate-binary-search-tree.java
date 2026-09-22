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
    public boolean ValidBST(TreeNode root ,long[]range) {
        if(root==null)return true;

        if(root.val>=range[1] ||root.val<=range[0])return false;
        // int min=Math.max(root.val,range[0]);
        // int max=Math.min(root.val,range[1]);
        return ValidBST(root.left,new long[]{range[0] , root.val}) && ValidBST(root.right ,new long[]{root.val,range[1]});
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null || (root.left==null && root.right==null))return true;
        return ValidBST(root,new long[]{Long.MIN_VALUE, Long.MAX_VALUE});
    }
}