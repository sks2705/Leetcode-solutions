class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int []delcol={0,-1,0,1};
        int[]delrow={-1,0,1,0};
        int [][] vis=new int[m][n];
        for(int i =0;i<n;i++){
            if(vis[0][i]==0 && board[0][i]=='O'){
                dfs(0,i,vis,board,delrow,delcol);
            }
            if(vis[m-1][i]==0 && board[m-1][i]=='O'){
                dfs(m-1,i,vis,board,delrow,delcol);
            }
        }
        for(int j =0;j<m;j++){
            if(vis[j][0]==0 && board[j][0]=='O'){
                dfs(j,0,vis,board,delrow,delcol);
            }
            if(vis[j][n-1]==0 && board[j][n-1]=='O'){
                dfs(j,n-1,vis,board,delrow,delcol);
            }
        }

        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0 && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }

    private void dfs(int row,int col,int[][]vis,char[][]board,int [] delrow,int []delcol){
        vis[row][col]=1;
        int m=board.length;
        int n =board[0].length;
        for(int i=0;i<4;i++){
            int nrow=delrow[i]+row;
            int ncol=delcol[i]+col;
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 && board[nrow][ncol]=='O'){
                dfs(nrow,ncol,vis,board,delrow,delcol);
            }
        }
    }
}