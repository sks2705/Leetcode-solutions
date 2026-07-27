class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
       int n = grid.length;
       int m=grid[0].length;
       int maxArea=0;
       int [][] vis = new int [n][m];
       for(int row =0;row<n;row++){
        for(int col=0;col<m;col++){
            if(vis[row][col]==0 && grid[row][col]==1){
                int max= bfs(grid,vis,col,row);
                 maxArea=Math.max(max,maxArea);
            }
        }
       }
       return maxArea;
    }
    public int bfs(int [][] grid,int[][] vis,int col,int row){
        vis[row][col]=1;
        Queue<Pair> q= new LinkedList<>();
        q.offer(new Pair(row,col));
        int n=grid.length;
        int m=grid[0].length;
        int[] drow={-1,0,1,0};
        int[] dcol={0,-1,0,1};
        int area=0;
        while(!q.isEmpty()){
            Pair p =q.poll();
             row=p.first;
             col=p.second;
            area++;
            for(int i=0;i<4;i++){
                int nrow=drow[i]+row;
                int ncol=dcol[i]+col;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                       vis[nrow][ncol]=1;
                       q.add(new Pair(nrow,ncol));
                }

            }
        }
        return area;
    }
}