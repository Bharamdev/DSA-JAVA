class Solution {
    int mod = 1000000007;
    int n;
    int m;
    int[][][] dp;
    public int numberOfPaths(int[][] grid, int k) {
        n=grid.length;
        m=grid[0].length;
        dp = new int[n][m][k];
        for(int[][] arr: dp) {
            for(int[] d: arr) Arrays.fill(d, -1);
        }
        return fn(0,0,0,grid,k);
    }
    int fn(int i, int j, int sum, int[][] grid, int k){
        if(i>=n|| j>=m) return 0;
        if(i==n-1 && j==m-1){
            return (sum+grid[i][j])%k==0 ? 1 : 0;
        }
        if(dp[i][j][sum]!=-1) return dp[i][j][sum];
        int down = fn(i+1, j, (sum+grid[i][j])%k, grid, k);
        int right = fn(i, j+1, (sum+grid[i][j])%k, grid, k);
        return dp[i][j][sum] = (right+down)%mod;
    }
}