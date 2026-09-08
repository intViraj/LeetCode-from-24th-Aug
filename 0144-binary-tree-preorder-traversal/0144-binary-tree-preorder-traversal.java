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
    // public void preorder(TreeNode root , List<Integer> ans){
    //     if(root==null)return;
    //     ans.add(root.val);
    //     preorder(root.left ,ans);
    //     preorder(root.right,ans);
    //     return;
    // }
    public List<Integer> iterative(TreeNode root){
        Stack<TreeNode> stk=new Stack<>();
        List<Integer> pre=new ArrayList<>();
        if(root==null)return pre;
        stk.push(root);
        while(!stk.isEmpty()){
            TreeNode curr=stk.pop();
            pre.add(curr.val);

            if(curr.right!=null){
                stk.push(curr.right);
            }

            if(curr.left!=null){
                stk.push(curr.left);
            }
        }
        return pre;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        // List<Integer> ans = new ArrayList<>();
        // if (root == null) {
        //     return ans;
        // }
        // ans.add(root.val);
        // ans.addAll(preorderTraversal(root.left));
        // ans.addAll(preorderTraversal(root.right));
        // // preorder(root,ans);
        // return ans;

        return iterative(root);
    }
}