// User function Template for Java
class Solution {
    int minCost(int[] height) {
        // code here
        int n = height.length;
        int[] dp = new int[n];
        int prev2 = Integer.MAX_VALUE;
        int prev = Integer.MIN_VALUE;
        dp[0]=0;
        for(int i=1;i<n;i++){
            prev = Math.abs(height[i]-height[i-1]) + dp[i-1];
            if(i>1) prev2 = Math.abs(height[i]-height[i-2]) + dp[i-2];
            int min = Math.min(prev, prev2);
            dp[i]=min;
        }
        return dp[n-1];
    }
}