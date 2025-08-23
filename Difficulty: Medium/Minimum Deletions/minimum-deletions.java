class Solution {
    static int minDeletions(String s) {
        // code here
        int n=s.length();
        String reverse = new StringBuilder(s).reverse().toString();
        int m=reverse.length();
        int len = LCS(s, reverse, n, m);
        return n-len;
    }
    static int LCS(String s, String reverse, int n, int m){
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==reverse.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}