class Solution {
    public int count(int coins[], int sum) {
        // code here.
        int n=coins.length;
        int[][] dp = new int[n+1][sum+1];
        for(int i=0;i<=n;i++) dp[i][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                int pick = 0;
                if(j>=coins[i-1]){
                    pick = dp[i][j-coins[i-1]];
                }
                int notPick = dp[i-1][j];
                dp[i][j] = pick+notPick;
            }
        }
        return dp[n][sum];
    }
}