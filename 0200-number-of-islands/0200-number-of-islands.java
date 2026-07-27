class pair {
    int first;
    int second;
    public pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int c=0;
        int row=grid.length;
        int col=grid[0].length;
        int [][] vis = new int[row][col];
        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    c++;
                    bfs(grid,vis,i,j);
                }

            }
        }
        return c;
    } 
    private void bfs(char[][] grid,int[][] vis,int row,int col){
        vis [row][col]=1;
        Queue<pair> queue=new LinkedList<>();
        queue.add(new pair(row,col));
        int [] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        int n=grid.length;
        int m=grid[0].length;
        while(!queue.isEmpty()){
            pair p = queue.poll();
            int r=p.first;
            int c=p.second;
            for(int i =0;i<4;i++){
                int nrow=dr[i]+r;
                int ncol=dc[i]+c;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]=='1'){
                    vis[nrow][ncol]=1;
                    queue.add(new pair(nrow,ncol));
                }
            }
        }

    } 
}
