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
    public void post(TreeNode root , List<Integer> ans){
        if(root==null)return;
        post(root.left,ans);
        post(root.right,ans);
        ans.add(root.val);
        return;
    }
    public List<Integer> tstk(TreeNode root){
        if(root==null)return new ArrayList<>();
        Stack<TreeNode> stk1=new Stack<>();
        Stack<TreeNode> stk2=new Stack<>();

        List<Integer> post=new ArrayList<>();
        stk1.push(root);
        while(!stk1.isEmpty()){
            TreeNode curr=stk1.pop();
            stk2.push(curr);
            if(curr.left!=null)stk1.push(curr.left);
            if(curr.right!=null)stk1.push(curr.right);
        }
        while(!stk2.isEmpty()){
            post.add(stk2.pop().val);
        }
        return post;
    }




    public List<Integer> stk(TreeNode root){
        if(root==null)return new ArrayList<>();

        Stack<TreeNode> st=new Stack<>();
        List<Integer> post=new ArrayList<>();

        TreeNode curr=root;
        while(curr!=null || !st.isEmpty()){

            if(curr!=null){
                st.push(curr);
                curr=curr.left;
            }else{
                TreeNode temp=st.peek().right;
                if(temp==null){
                    temp=st.peek();
                    st.pop();
                    post.add(temp.val);
                    while(!st.isEmpty() && temp==st.peek().right){
                        temp=st.peek();
                        st.pop();
                        post.add(temp.val);
                    }
                }else{
                    curr=temp;
                }
            }
        }
        return post;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        // List<Integer> ans=new ArrayList<>();

        // if(root==null)return ans;

        // ans.addAll(postorderTraversal(root.left));
        // ans.addAll(postorderTraversal(root.right));
        // ans.add(root.val);
        // // post(root,ans);
        // return ans;

        // return tstk(root);
        return stk(root);
    }
}