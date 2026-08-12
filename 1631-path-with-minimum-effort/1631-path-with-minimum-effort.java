import java.util.*;

class Pair {
    int distance;
    int row;
    int col;

    public Pair(int distance, int row, int col) {
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.distance - b.distance);

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int) 1e9);
        }

        dist[0][0] = 0;
        pq.add(new Pair(0, 0, 0));

        int[] dr = {0, -1, 0, 1};
        int[] dc = {1, 0, -1, 0};

        while (!pq.isEmpty()) {

            Pair it = pq.poll();
            int row = it.row;
            int col = it.col;
            int diff = it.distance;

            // Destination reached so returning the answer here
            if (row == n - 1 && col == m - 1) {
                return diff;
            }
            for (int i = 0; i < 4; i++) {
                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m) {

                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]),diff);
                    if (newEffort < dist[nrow][ncol]) {
                        dist[nrow][ncol] = newEffort;
                        pq.add(  new Pair(newEffort, nrow, ncol));
                    }
                }
            }
        }

        return 0;
    }
}