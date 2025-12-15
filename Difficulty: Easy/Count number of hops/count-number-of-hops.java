// User function Template for Java

class Solution {
    // Function to count the number of ways in which frog can reach the top.
    static int countWays(int n) {
        // add your code here
        int[] dp = new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            for(int step=1;step<=3;step++){
                if(i-step>=0){
                    dp[i] += dp[i-step];
                }
            }
        }
        return dp[n];
    }
}
