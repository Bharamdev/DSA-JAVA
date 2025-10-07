class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(String s: strs){
            int ones=0,zeros=0;
            for(char ch: s.toCharArray()){
                if(ch=='0') zeros++;
                else ones++;
            }
            for(int i=m; i>=zeros;i--){
                for(int j=n; j>=ones; j--){
                    dp[i][j] = Math.max(dp[i][j], 1+dp[i-zeros][j-ones]);
                }
            }
        }
        return dp[m][n];
    }
}