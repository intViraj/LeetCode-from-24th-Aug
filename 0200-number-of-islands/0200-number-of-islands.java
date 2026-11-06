class Solution {
    int [][] directions=new int [][] {{0,1},{1,0},{-1,0},{0,-1}};

    public void DFS(int n,int m,char[][] grid,int []src){
        grid[src[0]][src[1]]='$';

        for(int [] dir : directions){
            int x=src[0]+dir[0];
            int y=src[1]+dir[1];

            if(x<0 || x>=n || y<0 || y>=m || grid[x][y]=='0' || grid[x][y]=='$')continue;
            DFS(n,m,grid,new int []{x,y});
        }
        return;
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int Islands=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!='0' && grid[i][j]!='$'){
                    Islands++;
                    DFS(n,m,grid,new int[]{i,j});
                }
            }
        }
        return Islands;
    }
}