// User function Template for Java
class Solution {
    public int maximumPath(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<m;i++) dp[0][i] = mat[0][i];
        for(int i=1;i<n;i++){
            int left=Integer.MIN_VALUE, right=Integer.MIN_VALUE,
            top=Integer.MIN_VALUE;
            for(int j=0;j<m;j++){
                if(j<m-1) right = mat[i][j] + dp[i-1][j+1];
                if(j>0) left = mat[i][j] + dp[i-1][j-1];
                top = mat[i][j] + dp[i-1][j];
                dp[i][j] = Math.max(top, Math.max(left,right));
            }
        }
        int max=0;
        for(int i=0;i<m;i++) max = Math.max(max, dp[n-1][i]);
        return max;
    }
}