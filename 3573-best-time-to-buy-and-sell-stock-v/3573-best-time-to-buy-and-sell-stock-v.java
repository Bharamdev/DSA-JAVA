class Solution {
    long[][][] dp;
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        dp = new long[n][k+1][3];
        for(long[][] arr: dp){
            for(long[] a: arr) Arrays.fill(a,Long.MIN_VALUE);
        } 
        return fn(0,0,0,prices,k);
    }
    long fn(int idx, int trans, int state, int[] prices, int k){
        if(idx==prices.length || trans==k) {
            return state == 0 ? 0 : Long.MIN_VALUE / 2;
        }
        if(dp[idx][trans][state] != Long.MIN_VALUE) return dp[idx][trans][state];
        // Skip
        long ans= fn(idx+1, trans, state, prices, k);;
        if(state==0){
            //  Buy
            ans = Math.max(ans, -prices[idx] + fn(idx+1, trans, 1, prices, k));
            ans = Math.max(ans, prices[idx] + fn(idx+1, trans, 2, prices, k)); 
        }
        else if(state==1){
            ans = Math.max(ans, prices[idx] + fn(idx+1, trans+1, 0, prices, k));
        }
        else{
            ans = Math.max(ans, -prices[idx] + fn(idx+1, trans+1, 0, prices, k));
        }
        return dp[idx][trans][state] = ans;
    }
}