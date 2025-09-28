class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        int n=prices.length;
        dp = new int[n][2];
        for(int[] arr: dp) Arrays.fill(arr,-1);
        return fn(0,1,prices,n);
    }
    int fn(int idx, int buy, int[] prices, int n){
        if(idx==n) return 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        if(buy==1){
            int take = -prices[idx] + fn( idx+1, 0, prices, n);
            int notTake = fn(idx+1, 1, prices, n);
            dp[idx][buy] = Math.max( take, notTake );
        }
        else{
            int sell = prices[idx] + fn(idx+1, 1, prices, n);
            int notSell = fn(idx+1, 0, prices, n);
            dp[idx][buy] = Math.max(sell, notSell);
        }
        return dp[idx][buy];
    }
}