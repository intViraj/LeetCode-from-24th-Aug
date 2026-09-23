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
class Solution{
    HashSet<Integer> required=new HashSet<>();
    boolean found=false;
    public void find(TreeNode root ,int k){
        if(root==null || found)return;
        if(required.contains(root.val)){
            found=true;
            return;
        }
        required.add(k-root.val);
        find(root.left,k);
        find(root.right,k);
    }
    public boolean findTarget(TreeNode root, int k) {
        find(root,k);
        return found;
    }
}