// User function Template for Java

class Solution {
    // Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) {
        // Your code here
        int[][] dp = new int[a][b];
        for(int i=0;i<a;i++){
            int left=0, up=0;   
            for(int j=0;j<b;j++){
                if(i==0 && j==0) dp[i][j]=1;
                else{
                    if(j>0) left = dp[i][j-1];
                    if(i>0) up = dp[i-1][j];
                    dp[i][j] = left+up;
                }
            }
        }
        return dp[a-1][b-1];
    }
}