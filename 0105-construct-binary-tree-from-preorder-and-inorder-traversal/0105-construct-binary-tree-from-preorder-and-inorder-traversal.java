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
    int idx=0;
    public TreeNode solve(int[] preorder, int[] inorder,int start,int end,HashMap<Integer,Integer> map){
        if(start>end)return null;
        if(idx>=preorder.length)return null;
        int rootval=preorder[idx];
        int rootidx=map.get(rootval);
        idx++;
        TreeNode root=new TreeNode(rootval);
        root.left=solve(preorder,inorder,start,rootidx-1,map);
        root.right=solve(preorder,inorder,rootidx+1,end,map);

        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=preorder.length;
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        return solve(preorder,inorder,0,n-1,map);
    }
}