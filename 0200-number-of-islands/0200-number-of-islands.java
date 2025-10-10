class Solution {
    int[] delrow = {-1,0,+1,0};
    int[] delcol = {0,+1,0,-1};
    int n;
    int m;
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int islands=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    dfs(i, j, vis, grid);
                    islands++;
                }
            }
        }
        return islands;
    }
    void dfs(int row, int col, boolean[][] vis, char[][] grid){
        vis[row][col] = true;
        for(int i=0;i<4;i++){
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && 
               !vis[nrow][ncol] && grid[nrow][ncol]=='1'){
                dfs(nrow, ncol, vis, grid);
               }
        }
    }
}