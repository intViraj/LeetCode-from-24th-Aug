class Solution {
    Boolean [][]dp;
    public boolean solve(String s ,int i,int n ,int balance){
        if(balance<0) return false;
        if(i>=n){
            if(balance==0)return dp[i][balance]=true;
            return dp[i][balance]=false;
        }
        if(dp[i][balance]!=null)return dp[i][balance];
        if(s.charAt(i)=='('){
            return dp[i][balance]=solve(s,i+1,n,balance+1);
        }else if(s.charAt(i)==')'){
            return dp[i][balance]=solve(s,i+1,n,balance-1);
        }else{
            return dp[i][balance]=(solve(s,i+1,n,balance+1) || solve(s,i+1,n,balance)|| solve(s,i+1,n,balance-1));
        }
    }
    public boolean checkValidString(String s) {
        int n=s.length();
        dp=new Boolean[n+1][n+1];
        return solve(s,0,n,0);

    }
}