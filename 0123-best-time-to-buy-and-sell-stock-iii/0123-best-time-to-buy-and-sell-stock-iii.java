class Solution {
    int[][][] dp;
    public int maxProfit(int[] prices) {
        int n=prices.length;
        dp = new int[n][2][3];
        for(int[][] arr: dp ){
            for(int[] a: arr) Arrays.fill(a, -1);
        }
        return fn(0, 1, 0, prices, n);
    }
    int fn(int idx, int buy, int cnt, int[] prices, int n){
        if(idx==n || cnt==2) return 0;
        if(dp[idx][buy][cnt] != -1) return dp[idx][buy][cnt];
        if(buy==1){
            int take = -prices[idx] + fn(idx+1, 0, cnt, prices, n);
            int notTake = fn(idx+1, 1, cnt, prices, n);
            dp[idx][buy][cnt] = Math.max(take, notTake);
        }
        else{
            int sell = prices[idx] + fn(idx+1, 1, cnt+1, prices, n);
            int notSell = fn(idx+1, 0, cnt, prices, n);
            dp[idx][buy][cnt] = Math.max(sell, notSell);
        }
        return dp[idx][buy][cnt];
    }
}