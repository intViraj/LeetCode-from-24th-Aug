class Solution {
    String result="";
    public boolean solve(String target, int[] freq, int i, int n , String ans , boolean isgreater){
        if(i>=n){
            if(isgreater){
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

            if(solve(target,freq,i+1,n,ans,greater)){
                return true;
            }

            ans=ans.substring(0,ans.length()-1);
            freq[j-'a']++;
        }
        return false;
    }
    public String lexGreaterPermutation(String s, String target) {
        int n=s.length();

        int [] freq=new int[26];

        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }

        solve(target,freq,0,n,"", false);

        return result;
    }
}