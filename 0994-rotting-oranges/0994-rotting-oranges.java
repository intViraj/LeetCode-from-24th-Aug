class Solution {
    int [][]directions=new int [][]{{0,1},{1,0},{0,-1},{-1,0}};

    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m = grid[0].length;

        boolean [][]visited=new boolean[n][m];
        int fresh=0;
        ArrayList<int[]> rotten=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    rotten.add(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;
        Queue<int[]> q=new LinkedList<>();

        for(int [] r: rotten){
            q.add(r);
            visited[r[0]][r[1]]=true;
        }
        int time=0;
        while(!q.isEmpty()){
            int len=q.size();
            boolean changed = false;
            for(int i=0;i<len;i++){
                int []curr=q.poll();
                for(int [] dir : directions){
                    int x=curr[0]+dir[0];
                    int y=curr[1]+dir[1];

                    if(x>=0 && x<n && y>=0 && y<m && !visited[x][y] && grid[x][y]!=0){
                        visited[x][y]=true;
                        q.add(new int []{x,y});
                        fresh--;
                        changed=true;
                    }
                }
            }
            if(changed)time++;
            
        }
        return fresh==0 ? time : -1;
    }
}