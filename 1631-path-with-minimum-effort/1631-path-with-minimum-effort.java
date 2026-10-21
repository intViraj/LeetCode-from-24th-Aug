
import java.util.*;

class Solution {

    int[][] directions = {{0, 1},{1, 0},{0, -1},{-1, 0}};

    class Node {
        int wt, i, j;

        Node(int wt, int i, int j) {
            this.wt = wt;
            this.i = i;
            this.j = j;
        }
    }

    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;
        int[][] result = new int[n][m];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        TreeSet<Node> set = new TreeSet<>((a, b) -> {
            if (a.wt != b.wt) {
                return Integer.compare(a.wt, b.wt);
            }
            if (a.i != b.i) {
                return Integer.compare(a.i, b.i);
            }
            return Integer.compare(a.j, b.j);
        });

        result[0][0] = 0;
        set.add(new Node(0, 0, 0));

        while (!set.isEmpty()) {

            Node curr = set.pollFirst();

            int i = curr.i;
            int j = curr.j;
            int effort = curr.wt;

            if (effort > result[i][j]) {
                continue;
            }

            if (i == n - 1 && j == m - 1) {
                return effort;
            }

            for (int[] dir : directions) {

                int x = i + dir[0];
                int y = j + dir[1];

                if (x < 0 || x >= n || y < 0 || y >= m) {
                    continue;
                }

                int edgeDiff = Math.abs(
                    heights[i][j] - heights[x][y]
                );

                int newEffort = Math.max(effort, edgeDiff);

                if (newEffort < result[x][y]) {

                    set.remove(new Node(result[x][y], x, y));

                    result[x][y] = newEffort;

                    set.add(new Node(newEffort, x, y));
                }
            }
        }

        return result[n - 1][m - 1];
    }
}
