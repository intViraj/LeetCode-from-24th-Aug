class Solution {
    String result="";
    public boolean solve(String target, int[] freq, int i, int n , String ans , boolean isgreater,char mid){
        if(i>=n/2){
            String reversed=new StringBuilder(ans).reverse().toString();
            ans= (mid=='$') ? ans+reversed : ans+mid+reversed;
            if(isgreater){
                result=ans;
                return true;
            }else if(ans.compareTo(target)>0){
                result=ans;
                return true;
            }
            return false;
        }
        char curr=target.charAt(i);
        int curridx=curr-'a';
        for(char j='a';j<='z';j++){
            if(freq[j-'a']<=0)continue;
            if(isgreater==false && j<target.charAt(i)) continue;
            ans+=j;
            freq[j-'a']--;
            boolean greater= (isgreater || j>target.charAt(i));

            if(solve(target,freq,i+1,n,ans,greater,mid)){
                return true;
            }

            ans=ans.substring(0,ans.length()-1);
            freq[j-'a']++;
        }
        return false;
    }
    public String lexPalindromicPermutation(String s, String target) {
        int n=s.length();

        int [] freq=new int [26];

        for(char x : s.toCharArray()){
            freq[x-'a']++;
        }
        char mid='$';
        int cntodd=0;
        for(int i=0;i<26;i++){
            if(freq[i]%2==0){
                freq[i]/=2;
            }else{
                mid=(char)(i+'a');
                freq[i]/=2;
                cntodd++;
            }
        }
        if(cntodd>1)return "";
        solve(target,freq,0,n,"",false,mid);
        return result;

    }
}