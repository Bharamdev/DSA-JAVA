class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for(int[] arr: dp) Arrays.fill(arr,-1);
        return fn(0, 1, prices);
    }
    int fn(int idx, int buy, int[] prices){
        if(idx>=prices.length) return 0;
        if(dp[idx][buy] != -1) return dp[idx][buy]; 
        if(buy==1){
            dp[idx][buy]= Math.max(-prices[idx]+fn(idx+1, 0, prices), fn(idx+1, 1, prices));
        }
        else{
            dp[idx][buy]= Math.max(prices[idx]+fn(idx+2, 1, prices), fn(idx+1, 0, prices));
        }
        return dp[idx][buy];
    }
}