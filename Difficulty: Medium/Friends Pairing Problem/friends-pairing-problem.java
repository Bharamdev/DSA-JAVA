// User function Template for Java

class Solution {
    public long countFriendsPairings(int n) {
        // code here
        if(n<=2) return n;
        long[] dp = new long[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1] + (long)(i-1) * dp[i-2];
        }
        return dp[n];
    }
}
