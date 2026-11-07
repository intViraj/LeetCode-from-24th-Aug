
class Solution {
    int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> q = new LinkedList<>();

        // Add all zero cells initially
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[]{i,j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        // Multi-source BFS
        while(!q.isEmpty()) {
            int[] curr = q.poll();

            int x = curr[0];
            int y = curr[1];

            for(int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                if(mat[nx][ny] == -1) {
                    mat[nx][ny] = mat[x][y] + 1;
                    q.add(new int[]{nx,ny});
                }
            }
        }

        return mat;
    }
}
