class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            int left=0,top=0;
            for(int j=0;j<m;j++){
                if(obstacleGrid[i][j]==1) dp[i][j]=0;
                else if(i==0 && j==0) dp[i][j]=1;
                else{
                    if(i>0) top = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = top+left;
                }
            }
        }
        return dp[n-1][m-1];
    }
}