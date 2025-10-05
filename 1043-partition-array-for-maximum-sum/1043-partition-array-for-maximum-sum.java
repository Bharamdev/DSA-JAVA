class Solution {
    int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return fn(0,arr,k);
    }
    int fn(int i, int[] arr, int k){
        if(i==arr.length) return 0;
        if(dp[i] != -1) return dp[i];
        int len=0;
        int max=0;
        int ans=0;
        for(int idx=i; idx<Math.min(arr.length, i+k); idx++){
            len++;
            max = Math.max(max, arr[idx]);
            int sum = len*max + fn(idx+1, arr, k);
            ans = Math.max(ans, sum);
        } 
        return dp[i]=ans;
    }
}