class Solution {
    int[][] dp;
    public int maxProfit(int[] prices, int fee) {
        dp = new int[prices.length][2];
        for(int[] arr: dp) Arrays.fill(arr,-1);
        return fn(0, 1, prices, fee);
    }
    int fn(int idx, int buy, int[] prices, int fee){
        if(idx>=prices.length) return 0;
        if(dp[idx][buy] != -1) return dp[idx][buy]; 
        if(buy==1){
            dp[idx][buy]= Math.max(-prices[idx] + fn(idx+1,0, prices, fee), 
                                  fn(idx+1, 1, prices, fee));
        }
        else{
            dp[idx][buy]= Math.max(prices[idx] + fn(idx+1, 1, prices, fee) - fee, 
                                  fn(idx+1, 0, prices, fee));
        }
        return dp[idx][buy];
    }
}