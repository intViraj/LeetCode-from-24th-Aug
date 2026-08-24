class Solution {
    // public int solve(int i){
    //     if(i==n-1){
    //         return dp[i]=prefix[n-1];
    //     }
    //     if(dp[i]!=-1)return dp[i];
    //     int take=prefix[i]-solve(i+1);
    //     int skip=solve(i+1);

    //     return dp[i]=Math.max(take,skip);
    // }
    public int stoneGameVIII(int[] stones) {
        int n=stones.length;
        int[] dp=new int[n+1];
        int [] prefix=new int [n];
        prefix[0]=stones[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+stones[i];
        }
        dp[n-1]=prefix[n-1];
        for (int i = n - 2; i >= 1; i--) {
            dp[i] = Math.max(prefix[i] - dp[i + 1], dp[i + 1]);
        }
        return dp[1];
    }
}