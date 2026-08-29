class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length;

        int [] temp=new int [n];

        System.arraycopy(nums, 0, temp, 0, n);
        Arrays.sort(temp);
        
        int grpno=0;
        HashMap<Integer,List<Integer>> grp=new HashMap<>();
        HashMap<Integer,Integer> numtogrp=new HashMap<>();
        numtogrp.put(temp[0], 0);
        grp.computeIfAbsent(0,k -> new ArrayList<>()).add(temp[0]);
        for(int i=1;i<n;i++){
            if(Math.abs(temp[i]-temp[i-1])<=limit){
                grp.computeIfAbsent(grpno , k->new ArrayList<Integer>()).add(temp[i]);
                numtogrp.put(temp[i],grpno);
            }else{
                grp.put(++grpno , new ArrayList<Integer>(List.of(temp[i])));
                numtogrp.put(temp[i],grpno);
            }
        }
        for(int i=0;i<n;i++){
            int currgrp=numtogrp.get(nums[i]);
            int ele=grp.get(currgrp).remove(0);
            temp[i]=ele;
        }
        return temp;
    }
}