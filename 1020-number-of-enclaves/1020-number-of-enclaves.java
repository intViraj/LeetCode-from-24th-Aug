class Solution {
    int [][]directions=new int [][]{{0,1},{1,0},{0,-1},{-1,0}};

    public void DFS(int n,int m,int[][] grid,boolean [][]visited,int[]src){
        visited[src[0]][src[1]]=true;

        for(int [] dir : directions){
            int x=src[0]+dir[0];
            int y=src[1]+dir[1];

            if(x<0 || x>=n ||y<0 || y>=m || visited[x][y] || grid[x][y]==0){
                continue;
            }
            DFS(n,m,grid,visited,new int []{x,y});
        }
        return;
    }
    public int numEnclaves(int[][] grid) {
       int n=grid.length;
       int m=grid[0].length;
        boolean [][]visited=new boolean [n][m];

        for(int i=0;i<n;i++){
            if(grid[i][0]==1){
                DFS(n,m,grid,visited,new int []{i,0});
            }
            if(grid[i][m-1]==1){
                DFS(n,m,grid,visited,new int []{i,m-1});
            }
        }
        for(int j=0;j<m;j++){
            if(grid[0][j]==1){
                DFS(n,m,grid,visited,new int []{0,j});
            }
            if(grid[n-1][j]==1){
                DFS(n,m,grid,visited,new int []{n-1,j});
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && visited[i][j]==false){
                    count++;
                }
            }
        }
        return count;
    }
}