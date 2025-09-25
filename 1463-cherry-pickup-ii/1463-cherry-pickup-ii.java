class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int j1 = 0, j2 = m-1;
        int[][][] dp = new int[n][m][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<m;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return pickup(n, m, 0, j1, j2, grid, dp);
    }
    int pickup(int n, int m, int i, int j1, int j2, int[][] grid, int[][][] dp){
        if(j1<0 || j1>=m || j2<0 || j2>=m ) return -1000000;
        if(i==n-1){
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        int maxi=0;
        for(int dj1=-1; dj1<=1; dj1++){
            for(int dj2=-1; dj2<=1; dj2++){
                int val=0;
                if(j1==j2) val = grid[i][j1];
                else val = grid[i][j1] + grid[i][j2];
                val += pickup(n, m, i+1, j1+dj1, j2+dj2, grid, dp);
                maxi = Math.max(maxi,val);
            }
        }
        return dp[i][j1][j2] = maxi;
    }
}