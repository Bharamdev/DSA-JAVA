class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                int notSplit = j*(i-j);
                int split = j*dp[i-j];
                dp[i] = Math.max(dp[i], Math.max(split, notSplit));
            }
        }
        return dp[n];
    }
}