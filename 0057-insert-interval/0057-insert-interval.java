class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        int nstart=newInterval[0];
        int nend=newInterval[1];
        int i=0;

        List<int []> ans=new ArrayList<>();
        while(i<n && intervals[i][1]<newInterval[0]){
            ans.add(intervals[i]);
            i++;
        }
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(newInterval[0] , intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1] , intervals[i][1]);
            i++;
        }
        ans.add(newInterval);
        while(i<n){
            ans.add(intervals[i]);
            i++;
        }

        int [][] result=new int[ans.size()][2];
        int idx=0;
        for(int[] j : ans){
            result[idx++]=j;
        }
        return result;
    }
}