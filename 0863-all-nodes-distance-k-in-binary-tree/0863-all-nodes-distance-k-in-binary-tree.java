/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void inorder(TreeNode root , HashMap<TreeNode,TreeNode> map){
        if(root==null)return;

        if(root.left!=null)map.put(root.left,root);
        inorder(root.left ,map);
        if(root.right!=null)map.put(root.right,root);
        inorder(root.right , map);

        return;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans=new ArrayList<>();
        HashMap<TreeNode,TreeNode> map=new HashMap<>();

        inorder(root,map);

        int level=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(target);
        HashSet<TreeNode>visited=new HashSet<>();
        visited.add(target);
        while(!q.isEmpty() && level<=k){
            int n=q.size();
            
            while(n>0){
                TreeNode curr=q.poll();
                if(level==k){
                    ans.add(curr.val);
                }
                if(curr.left!=null && !visited.contains(curr.left)){
                    q.add(curr.left);
                    visited.add(curr.left);
                }
                if(curr.right!=null && !visited.contains(curr.right)){
                    q.add(curr.right);
                    visited.add(curr.right);
                }
                if(map.containsKey(curr) && !visited.contains(map.get(curr))){
                    q.add(map.get(curr));
                    visited.add(map.get(curr));
                }
                n--;
            }
            level++;
        }
        return ans;
    }
}