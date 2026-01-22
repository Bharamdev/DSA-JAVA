class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int mod=(int)1e9+7;
        int[][] dp = new int[n+1][target+1];
        dp[0][0]=1;
        for(int i=1;i<=n;i++){
            for(int sum=1;sum<=target;sum++){
                for(int face=1;face<=k;face++){
                    if(sum>=face){
                        dp[i][sum] = (dp[i][sum] + dp[i-1][sum-face])%mod;
                    }
                }
            }
        }
        return dp[n][target];
    }
}