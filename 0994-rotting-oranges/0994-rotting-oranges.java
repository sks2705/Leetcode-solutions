class Pair {
    int row;
    int col;
    int time;

    Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<Pair> q = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;

        int fresh = 0;

        int vis[][] = new int[n][m];

        // Put all initially rotten oranges into queue
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                }
                else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[] drow = {1, 0, -1, 0};
        int[] dcol = {0, 1, 0, -1};

        int time = 0;
        int freshRotten = 0;

        while(!q.isEmpty()) {

            Pair p = q.poll();

            int row = p.row;
            int col = p.col;
            int t = p.time;

            time = Math.max(time, t);

            // Check 4 directions
            for(int i = 0; i < 4; i++) {

                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow >= 0 && nrow < n &&
                   ncol >= 0 && ncol < m &&
                   grid[nrow][ncol] == 1 &&
                   vis[nrow][ncol] != 2) {

                    q.add(new Pair(nrow, ncol, t + 1));

                    vis[nrow][ncol] = 2;

                    freshRotten++;
                }
            }
        }

        if(freshRotten != fresh) {
            return -1;
        }

        return time;
    }
}