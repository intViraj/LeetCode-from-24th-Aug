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
    public void inorder(TreeNode root , List<Integer> ans){
        if(root==null)return;
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
        return;
    }
    public List<Integer> iterative(TreeNode root){
        if(root==null)return new ArrayList<>();
        Stack<TreeNode> stk=new Stack<>();
        List<Integer> l=new ArrayList<>();
        TreeNode curr=root;

        while(true){
            if(curr!=null){
                stk.push(curr);
                curr=curr.left;
            }else{
                if(stk.isEmpty())break;
                curr=stk.pop();
                l.add(curr.val);
                curr=curr.right;
            }
        }
        return l;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();

        // if(root==null)return ans;

        // ans.addAll(inorderTraversal(root.left));
        // ans.add(root.val);
        // ans.addAll(inorderTraversal(root.right));
        // inorder(root,ans);
        // return ans;

        return iterative(root);
    }
}