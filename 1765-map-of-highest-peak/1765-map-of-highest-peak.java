class Solution {
    int [][] directions=new int[][]{{1,0} ,{0,1},{-1,0},{0,-1}};
    public void multiBfs(int[][] isWater){


    }
    public int[][] highestPeak(int[][] isWater) {
        int n=isWater.length;
        int m=isWater[0].length;
        boolean [][]visited=new boolean[n][m];
        int [][]heights=new int[n][m];
        ArrayList<int[]> src=new ArrayList<>();
        Queue<int []> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isWater[i][j]==1){
                    src.add(new int []{i,j});
                }
            }
        }
        // for(int [] i : heights){
        //     Arrays.fill(i,-1);
        // }
        for(int [] i : src){
            q.add(i);
            heights[i[0]][i[1]]=0;
            visited[i[0]][i[1]]=true;
        }
        while(!q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){
                int [] curr=q.poll();
                int curr_height=heights[curr[0]][curr[1]];
                for(int [] dir:directions){
                    int x=curr[0]+dir[0];
                    int y=curr[1]+dir[1];

                    if(x>=n || x<0 || y>=m || y<0 || visited[x][y]){
                        continue;
                    }
                    heights[x][y]=curr_height+1;
                    
                    visited[x][y]=true;
                    q.add(new int []{x,y});
                }
            }
        }
        return heights;
    }
}