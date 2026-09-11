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
    public void preorder(TreeNode root,int col,int row,TreeMap<Integer,TreeMap<Integer,List<Integer>>> map){
        if(root==null){
            return;
        }
        
        map.computeIfAbsent(col,k->new TreeMap<>()).computeIfAbsent(row,k->new ArrayList<>()).add(root.val);
        preorder(root.left,col-1,row+1,map);
        preorder(root.right,col+1,row+1,map);
        return;
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer,TreeMap<Integer,List<Integer>>> map=new TreeMap<>();
        List<List<Integer>> result=new ArrayList<>();

        preorder(root,0,0,map);

        for(Map.Entry<Integer,TreeMap<Integer,List<Integer>>> entry : map.entrySet()){
            List<Integer> l=new ArrayList<>();
            for(Map.Entry<Integer , List<Integer>> each : entry.getValue().entrySet()){
                Collections.sort(each.getValue());
                l.addAll(each.getValue());
            }
            result.add(l);
        }
        return result;
    }
}