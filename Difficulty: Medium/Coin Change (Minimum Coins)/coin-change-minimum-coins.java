class Solution {

    public int minCoins(int coins[], int sum) {
        // code here
        int n=coins.length;
        int[][] dp = new int[n+1][sum+1];
        for(int i=0;i<=n;i++) dp[i][0] = 0;
        for(int j=0;j<=sum;j++) dp[0][j] = 10000000;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(j>=coins[i-1]){
                    dp[i][j] = Math.min(1+dp[i][j-coins[i-1]], dp[i-1][j]);
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        return (dp[n][sum] >= 10000000) ? -1 : dp[n][sum];
    }
}