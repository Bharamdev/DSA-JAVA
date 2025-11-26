class Solution {
    int mod = 1000000007;
    int n;
    int m;
    int[][][] dp;
    public int numberOfPaths(int[][] grid, int k) {
        n=grid.length;
        m=grid[0].length;
        // dp = new int[n][m][k];
        // for(int[][] arr: dp) {
        //     for(int[] d: arr) Arrays.fill(d, -1);
        // }
        // return fn(0,0,0,grid,k);

        // Tabulation
        dp = new int[n+1][m+1][k+1];
        for(int rem=0;rem<k;rem++){
            dp[n-1][m-1][rem] = (rem+grid[n-1][m-1])%k==0 ? 1 : 0;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 && j==m-1) continue;
                for(int rem=0;rem<k;rem++){
                    int r = (rem+grid[i][j])%k;
                    int down = dp[i+1][j][r];
                    int right = dp[i][j+1][r];
                    dp[i][j][rem] = (down+right)%mod;
                }
            }
        }
        return dp[0][0][0];
    }

    // Memo
    // int fn(int i, int j, int sum, int[][] grid, int k){
    //     if(i>=n|| j>=m) return 0;
    //     if(i==n-1 && j==m-1){
    //         return (sum+grid[i][j])%k==0 ? 1 : 0;
    //     }
    //     if(dp[i][j][sum]!=-1) return dp[i][j][sum];
    //     int down = fn(i+1, j, (sum+grid[i][j])%k, grid, k);
    //     int right = fn(i, j+1, (sum+grid[i][j])%k, grid, k);
    //     return dp[i][j][sum] = (right+down)%mod;
    // }
}