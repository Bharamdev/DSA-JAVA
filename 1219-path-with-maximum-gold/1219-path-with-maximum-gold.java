class Solution {
    int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    int max=0;
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0 && !vis[i][j]){
                    max = Math.max(max, dfs(i,j,grid,vis,0));
                }
            }
        }
        return max;
    }
    int dfs(int r, int c, int[][] grid, boolean[][] vis, int gold){
        vis[r][c]=true;
        gold+=grid[r][c];
        int maxgold = gold;
        for(int[] d: dir){
            int nr = r+d[0];
            int nc = c+d[1];
            if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && 
              !vis[nr][nc] && grid[nr][nc]!=0){
                maxgold = Math.max(maxgold, dfs(nr, nc, grid, vis, gold));
            }
        }
        vis[r][c]=false;
        return maxgold;
    }
}