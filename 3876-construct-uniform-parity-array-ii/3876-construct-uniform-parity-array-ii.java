class Solution {
    public boolean uniformArray(int[] nums1) {
        int n=nums1.length;

        int min=Integer.MAX_VALUE;
        int even=0;
        for(int i : nums1){
            min=Math.min(min,i);
            if(i%2==0)even++;
        }
        if(min%2==0 && even!=n)return false;
        return true;
    }
}