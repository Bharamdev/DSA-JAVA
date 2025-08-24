class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        int[][] dp = LCS(str1, str2, n, m);
        StringBuilder str = new StringBuilder();
        int i=n,j=m;
        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                str.append( str1.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(dp[i][j-1]>dp[i-1][j]){
                    str.append( str2.charAt(j-1));
                    j--;
                }
                else{
                    str.append( str1.charAt(i-1));
                    i--;
                }
            }
        }
        while(i>0){
            str.append( str1.charAt(i-1));
            i--;
        }
        while(j>0){
            str.append( str2.charAt(j-1));
            j--;
        }
        return str.reverse().toString();
    }
    public int[][] LCS(String str1, String str2, int n, int m){
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp;
    }
}