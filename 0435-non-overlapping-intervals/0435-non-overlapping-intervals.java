class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
       Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int cnt=0;
        int free=intervals[0][0];
        for(int i=0;i<n;i++){
            if(free<=intervals[i][0]){
                cnt++;
                free=intervals[i][1];
            }
        }
        return intervals.length-cnt;
    }
}