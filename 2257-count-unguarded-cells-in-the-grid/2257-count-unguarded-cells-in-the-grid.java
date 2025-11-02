class Solution {
    public int countUnguarded(int n, int m, int[][] guards, int[][] walls) {
        int[][] grid = new int[n][m];
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int[] g: guards) grid[g[0]][g[1]]=-1;
        for(int[] w: walls) grid[w[0]][w[1]]=-1;
        for(int[] g: guards){
            int r=g[0];
            int c=g[1];
            for(int[] d: dir){
                int nr = r+d[0];
                int nc = c+d[1];
                while(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]!=-1){
                    grid[nr][nc]=1;
                    nr+=d[0];
                    nc+=d[1];
                }
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0) cnt++;
            }
        }
        return cnt;
    }
}