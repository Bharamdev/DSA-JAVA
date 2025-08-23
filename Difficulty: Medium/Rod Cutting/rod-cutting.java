class Solution {
    public int cutRod(int[] price) {
        // code here
        int n=price.length;
        int sum=n;
        int[][] dp = new int[n+1][sum+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(j>=i){
                    dp[i][j] = Math.max(price[i-1]+dp[i][j-i],dp[i-1][j]);
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}