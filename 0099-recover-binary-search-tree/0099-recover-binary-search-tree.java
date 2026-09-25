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
    TreeNode first;
    TreeNode sec;
    TreeNode prev=null;
    public void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);
        if(prev!=null && root.val<prev.val){
            if(first==null ){
                first=prev;
            }
            sec=root;
        }
        prev=root;
        inorder(root.right);
    
    }
    public void recoverTree(TreeNode root) {
        first=null;
        sec=null;
        inorder(root);
        if(first==null && sec==null)return;
        int a=first.val;
        int b=sec.val;
        a=a^b;
        b=a^b;
        a=a^b;

        first.val=a;
        sec.val=b;
        
        return;
    }
}