class Solution {
    int n;
    Boolean [] dp;
    public boolean solve(int i , int[] nums){
        if(i==n-1 || i>=n)return dp[i]=true;
        if(dp[i]!=null)return dp[i];
        if(nums[i]==0)return dp[i]=false;
        for(int j=1;j<=nums[i];j++){
            if(solve(i+j ,nums)){
                return dp[i]=true;
            }
        }
        return dp[i]=false;
    }
    public boolean canJump(int[] nums) {
        n=nums.length;
        dp=new Boolean[n+1];

        return solve(0,nums);
    }
}