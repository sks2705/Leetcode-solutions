class Solution {
    public int islandPerimeter(int[][] grid) {
        int n =grid.length;
        int m = grid[0].length;
        int perimeter=0;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    perimeter+=4;
                    for(int k=0;k<4;k++){
                        int nr=drow[k]+i;
                        int nc=dcol[k]+j;
                        if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1){
                            perimeter--;
                        }
                    }
                }
            }
        }
        return perimeter;
        
    }
}