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
    int idx;
    public TreeNode solve(int[] inorder, int[] postorder,int start,int end,HashMap<Integer,Integer>map){
        if(start>end)return null;
        if(idx<0 || idx>postorder.length-1)return null;
        int rootval=postorder[idx];
        int ridx=map.get(rootval);
        idx--;
        TreeNode root=new TreeNode(rootval);
        root.right=solve(inorder,postorder,ridx+1,end,map);
        root.left=solve(inorder,postorder,start,ridx-1,map);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=postorder.length;
        idx=n-1;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        return solve(inorder,postorder,0,n-1,map);
    }
}