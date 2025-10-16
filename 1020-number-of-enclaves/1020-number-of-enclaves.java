class Solution {
    int[] delrows = {-1,0,1,0};
    int[] delcols = {0,1,0,-1};
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int j=0;j<m;j++){
            // First row
            if(!vis[0][j] && grid[0][j]==1 )dfs(0,j,vis,grid);
            // Last row
             if(!vis[n-1][j] && grid[n-1][j]==1 ) dfs(n-1,j,vis,grid);
        }
        for(int i=0;i<n;i++){
            // First col
             if(!vis[i][0] && grid[i][0]==1 ) dfs(i,0,vis,grid);
            // Last col
             if(!vis[i][m-1] && grid[i][m-1]==1 ) dfs(i,m-1,vis,grid);
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]==1) cnt++;
            }
        }
        return cnt;
    }
    void dfs(int r, int c, boolean[][] vis, int[][] grid){
        vis[r][c] = true;
        for(int i=0;i<4;i++){
            int nr = r+delrows[i];
            int nc = c+delcols[i];
            if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length
              && !vis[nr][nc] && grid[nr][nc]==1){
                dfs(nr, nc, vis, grid);
            }
        }
    }
}