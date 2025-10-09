class Solution {
    int[][] dp;
    public int minSteps(int n) {
        if(n==1) return 0;
        dp = new int[n][n];
        for(int[] a: dp) Arrays.fill(a,-1);
        return 1 + fn(1,1,n);
    }
    int fn(int current,int prev, int n){
        if(current==n) return 0;
        if(current>n) return Integer.MAX_VALUE/2;
        if(dp[current][prev] != -1) return dp[current][prev];
        int copyPaste = 2 + fn(current*2, current, n);
        int paste = 1 + fn(current+prev, prev, n);
        return dp[current][prev] = Math.min(paste, copyPaste);
    }
}