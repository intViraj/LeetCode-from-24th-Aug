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
    int max=Integer.MIN_VALUE;
    public int maxpath(TreeNode root){
        if(root==null)return 0;

        int left=maxpath(root.left);
        int right=maxpath(root.right);

        max=Math.max(max,Math.max(Math.max(left+right+root.val,Math.max(left,right)+root.val),root.val));

        return Math.max(root.val,Math.max(left,right)+root.val);
    }
    public int maxPathSum(TreeNode root) {
        if(root.left==null && root.right==null)return root.val;
        maxpath(root);
        return max;
    }
}