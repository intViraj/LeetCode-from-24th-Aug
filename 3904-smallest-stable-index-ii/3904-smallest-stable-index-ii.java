class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int minidx=n;

        int [] min=new int [n];
        int [] max=new int [n];

        min[n-1]=nums[n-1];
        max[0]=nums[0];
        for(int i=1;i<n;i++){
            min[n-1-i]=Math.min(min[n-i] , nums[n-i-1]);
            max[i]=Math.max(max[i-1] , nums[i]);
        }

        for(int i=0;i<n;i++){
            if(k>=(max[i]-min[i])){
                minidx=Math.min(minidx,i);
            }
        }
        return (minidx==n) ? -1 : minidx;
    }
}