class Solution {
    int [][] directions=new int [][]{{1,1},{1,-1},{-1,1},{0,1},{1,0},{0,-1},{-1,0},{-1,-1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1)return -1;

        Queue<int[]> q=new LinkedList<>();

        q.add(new int []{0,0});
        grid[0][0]=1;
        int dist=1;

        while(!q.isEmpty()){
            int size = q.size();

            for (int k = 0; k < size; k++) {
                int[] curr = q.poll();
                if (curr[0] == n - 1 && curr[1] == n - 1) {
                    return dist;
                }
                for (int[] dir : directions) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if (x < 0 || x >= n || y < 0 || y >= n) {
                        continue;
                    }
                    if (grid[x][y] == 1) {
                        continue;
                    }
                    grid[x][y] = 1;
                    q.offer(new int[]{x, y});
                }
            }
            dist++;
        }

        return -1;
    }
}