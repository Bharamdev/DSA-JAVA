class Solution {
    int n,m;
    ArrayList<int[]> borders = new ArrayList<>();
    boolean[][] vis;
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    int orig;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        n=grid.length;
        m=grid[0].length;
        vis = new boolean[n][m];
        orig=grid[row][col];
        dfs(row,col,grid,color);
        for(int[] a: borders){
            grid[a[0]][a[1]] = color;
        }
        return grid;
    }
    void dfs(int r, int c, int[][] grid, int color){
        vis[r][c]=true;
        boolean ok=false;
        for(int[] d: dir){
            int nr=r+d[0], nc=c+d[1];
            if(nr<0 || nc<0 || nr>=n || nc>=m){
                ok=true;
                continue;
            }
            if(grid[nr][nc]!=orig){
                ok=true;
                continue;
            }
            if(!vis[nr][nc]) dfs(nr, nc, grid, color);
        }
        if(ok) borders.add(new int[]{r,c});
    }
}