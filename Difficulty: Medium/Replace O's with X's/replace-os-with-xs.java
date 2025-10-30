class Solution {
    int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    public void fill(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int j=0;j<m;j++){
            if(!vis[0][j] && grid[0][j]=='O'){
                dfs(0,j,vis,grid);
            }
            if(!vis[n-1][j] && grid[n-1][j]=='O'){
                dfs(n-1,j,vis,grid);
            }
        }
        for(int i=0;i<n;i++){
            if(!vis[i][0] && grid[i][0]=='O'){
                dfs(i,0,vis,grid);
            }
            if(!vis[i][m-1] && grid[i][m-1]=='O'){
                dfs(i,m-1,vis,grid);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]) grid[i][j]='X';
            }
        }
    }
    void dfs(int r, int c, boolean[][] vis, char[][] grid){
        vis[r][c]=true;
        for(int[] d: dir){
            int nr = r+d[0];
            int nc = c+d[1];
            if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length
            &&!vis[nr][nc] && grid[nr][nc]=='O'){
                dfs(nr,nc,vis,grid);   
            }
        }
    }
}
