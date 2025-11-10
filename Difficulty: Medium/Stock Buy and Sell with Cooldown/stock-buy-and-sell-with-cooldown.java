class Solution {
    int[][] dp;
    public int maxProfit(int arr[]) {
        // Code here
        int n = arr.length;
        dp = new int[n][2];
        for(int[] d: dp) Arrays.fill(d,-1);
        return fn(0,1,arr);
    }
    int fn(int idx, int buy, int[] arr){
        if(idx>=arr.length) return 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        if(buy==1){
            dp[idx][buy] = Math.max(-arr[idx]+fn(idx+1, 0, arr),
                                    fn(idx+1, 1, arr));
        }
        else{
            dp[idx][buy] = Math.max(arr[idx]+fn(idx+2,1,arr), 
                                    fn(idx+1,0,arr));
        }
        return dp[idx][buy];
    }
}
