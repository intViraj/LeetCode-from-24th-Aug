class Solution {
    int [][] directions=new int [][]{{0,1},{1,0},{-1,0},{0,-1}};

    // public void BFS(int n,int m,int [][]images,int [][] visited,int[] src)
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        boolean[][]visited=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();

        visited[sr][sc]=true;
        int org=image[sr][sc];
        image[sr][sc]=color;
        q.add(new int []{sr,sc});

        while(!q.isEmpty()){
            int [] curr=q.poll();
            for(int [] dir : directions){
                int x=curr[0]+dir[0];
                int y=curr[1]+dir[1];

                if(x<0 || x>=n ||y<0 ||y>=m||visited[x][y]||image[x][y]!=org){
                    continue;
                }
                image[x][y]=color;
                visited[x][y]=true;
                q.add(new int []{x,y});
            }
        }
        return image;
    }
}