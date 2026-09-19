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
    class nidx{
        TreeNode root;
        int idx;
        nidx(TreeNode root,int idx){
            this.root=root;
            this.idx=idx;
        }
    }
    int max=0;
    public void lo(TreeNode root){
        if(root==null)return;
        Deque<nidx> q=new ArrayDeque<>();

        q.addFirst(new nidx(root,0));

        while(!q.isEmpty()){

            int n=q.size();
            int l=q.peekFirst().idx;
            int r=q.peekLast().idx;
            max=Math.max(max,r-l+1);
            while(n>0){
                int curridx=q.peekFirst().idx;
                TreeNode curr=q.pollFirst().root;
                if(curr.left!=null)q.add(new nidx(curr.left,(2*curridx)+1));
                if(curr.right!=null)q.add(new nidx(curr.right,(2*curridx)+2));
                n--;
            }
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        lo(root);
        return max;
    }
}