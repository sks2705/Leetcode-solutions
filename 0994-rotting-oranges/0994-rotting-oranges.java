
class Pair {
    int row;
    int col;
    int time;
    public Pair(int row, int col, int time) {
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
        int fresh=0;
        int [][] vis = new int [n][m];
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(grid[row][col]==2){
                    q.add(new Pair(row,col,0));  //rotten oranges
                    vis[row][col]=2;       
                }
                else if(grid[row][col]==1){
                    fresh++;
                }
            }
        }
        int []drow={-1,0,1,0};
        int []dcol={0,1,0,-1};
        int time = 0;
        int freshRotten=0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int t=p.time;
            time=Math.max(time,t);
            for(int i =0;i<4;i++){
                int nrow=row+drow[i];
                int ncol=col+dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]!=2){
                    q.add(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol]=2;
                    freshRotten++;
                }
            }

            }
            if(freshRotten!=fresh){
            return-1;
        }
        return time;
        
    }

}