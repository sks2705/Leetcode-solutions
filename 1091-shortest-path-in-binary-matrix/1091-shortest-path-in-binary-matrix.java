class Pair{
    int row;
    int col;
    int dist;
    Pair(int row,int col,int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}

class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {

        
        int n =grid.length;
        int m = grid[0].length;
        int sr=0;
        int sc=0;
        int dr=n-1;
        int dc=m-1;
         if (grid[sr][sc] == 1 || grid[dr][dc] == 1) {
            return -1;
        }
        boolean[][] vis=new boolean[n][m];
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{sr,sc,1});
        vis[sr][sc]=true;
        int drow[]={-1,-1,-1,0,0,1,1,1};
        int dcol[]={-1,0,1,-1,1,-1,0,1};
        while(!q.isEmpty()){
            int []curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            int dist=curr[2];
            if(r==dr && c==dc){
                return dist;
            }
            for(int i=0;i<8;i++){
                int nr=r+drow[i];
                int nc=c+dcol[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==0 && vis[nr][nc]==false){
                    vis[nr][nc]=true;
                    q.offer(new int[]{nr,nc,dist+1});
                }
            }

        }
        return -1;

    }
}