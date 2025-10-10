class Solution {
    public int countIslands(char[][] grid) {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]=='L'){
                    dfs(i, j, vis, grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    void dfs(int row, int col, boolean[][] vis, char[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        vis[row][col]=true;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int nrow = row+i;
                int ncol = col+j;
                if((nrow>=0 && nrow<n) && (ncol>=0 && ncol<m) &&
                   !vis[nrow][ncol] && grid[nrow][ncol]=='L' ){
                       dfs(nrow, ncol, vis, grid);
                   }
            }
        }
    }
}