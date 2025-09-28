class Solution {
    int[][][] dp;
    public int maxProfit(int k, int[] prices) {
        dp = new int[prices.length][2][k+1];
        for(int[][] arr: dp){
            for(int[] a: arr) Arrays.fill(a, -1);
        }
        return fn(0, 1, 0, prices, k);
    }
    int fn(int idx, int buy, int cnt, int[] prices, int k){
        if(idx==prices.length || cnt==k) return 0;
        if(dp[idx][buy][cnt] != -1) return dp[idx][buy][cnt];
        if(buy==1){
            int take = -prices[idx] + fn(idx+1, 0, cnt, prices, k);
            int notTake = fn(idx+1, 1, cnt, prices, k);
            dp[idx][buy][cnt] = Math.max(take, notTake);
        }
        else{
            int sell = prices[idx] + fn(idx+1, 1, cnt+1, prices, k);
            int notSell = fn(idx+1, 0, cnt, prices, k);
            dp[idx][buy][cnt] = Math.max(sell, notSell);
        }
        return dp[idx][buy][cnt];
    }
}