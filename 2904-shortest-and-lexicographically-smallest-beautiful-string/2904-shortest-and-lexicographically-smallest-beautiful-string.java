class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n=s.length();
        int l=0;
        int r=0;

        int cnt=0;

        String result="";
        while(r<n){
            if(s.charAt(r)=='1'){
                cnt++;
            }
            
            while(l<n && (cnt>k || s.charAt(l)=='0')){
                if(s.charAt(l)=='1'){
                    cnt--;
                }
                l++;
            }

            if(cnt==k){
                int currlen=r-l+1;
                if(currlen<result.length() || result.length()==0 ||(currlen==result.length() && result.compareTo(s.substring(l,l+currlen))>0)){
                    result=s.substring(l,l+currlen);
                }
            }

            r++;
        }
        return result;
    }
}