/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
      List<Integer> idx=new ArrayList<>();
      ListNode temp=head;
      ListNode prev=temp;
      temp=temp.next;
      int i=2;
      while(temp.next!=null){
        
        if((prev.val>temp.val && temp.val<temp.next.val) || (prev.val<temp.val && temp.val>temp.next.val)){
            idx.add(i);
        }
        i++;
        prev=temp;
        temp=temp.next;
      }
      if(idx.size()<=1)return new int[]{-1,-1};
      Collections.sort(idx);
      int min=Integer.MAX_VALUE;
      int max=idx.get(idx.size()-1)-idx.get(0);
      for(int a=0;a<idx.size()-1;a++){
        min=Math.min(min,Math.abs(idx.get(a+1)-idx.get(a)));
      }
      return new int []{min, max};
    }
}