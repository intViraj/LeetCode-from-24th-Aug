class Solution {
    int [][] directions={{1,0},{0,1},{-1,0},{0,-1}};
    public void solve(char[][] board) {
       int n=board.length;
       int m=board[0].length;

       Queue<int []> q=new LinkedList<>();
       boolean [][]visited=new boolean [n][m];

       for(int i=0;i<n;i++){
            if(board[i][0]=='O'){
                q.add(new int []{i,0});
                visited[i][0]=true;
            }
            if(board[i][m-1]=='O'){
                q.add(new int []{i,m-1});
                visited[i][m-1]=true;
            }
       } 
       for(int j=0;j<m;j++){
            if(board[0][j]=='O'){
                q.add(new int []{0,j});
                visited[0][j]=true;
            }
            if(board[n-1][j]=='O'){
                q.add(new int []{n-1,j});
                visited[n-1][j]=true;
            }
       }
       while(!q.isEmpty()){
        int []curr=q.poll();

        for(int []dir: directions){
            int x=curr[0]+dir[0];
            int y=curr[1]+dir[1];

            if(x<0 || x>=n || y<0 || y>=m || board[x][y]=='X' || visited[x][y]==true)continue;
            visited[x][y]=true;
            q.add(new int []{x,y});
        }
       }
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(board[i][j]=='O' && !visited[i][j]){
                board[i][j]='X';
            }
        }
       }
       return;
    }
}