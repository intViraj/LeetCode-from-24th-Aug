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
    public void level(TreeNode root , TreeMap<Integer,Integer> map){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        int row=0;
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                    row++;
                }
            }else{
                map.putIfAbsent(row, curr.val);
                if(curr.right!=null){
                    q.add(curr.right);
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
            }
        }
        return;
    }
    List<Integer> result=new ArrayList<>();
    public void iterative(TreeNode root, int level){
        if(root==null)return;

        if(level==result.size()){
            result.add(root.val);
        }
        iterative(root.right,level+1);
        iterative(root.left,level+1);
        return; 
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)return result;
        iterative(root,0);
        // TreeMap<Integer,Integer> map=new TreeMap<>();
        // level(root,map);
        // for(Map.Entry<Integer , Integer> entry : map.entrySet()){
        //     result.add(entry.getValue());
        // }
        return result;
    }
}