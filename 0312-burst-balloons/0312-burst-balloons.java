class Solution {
    int[][] dp;
    public int maxCoins(int[] nums) {
        int n =nums.length;
        int[] arr = new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        for(int i=0;i<n;i++) arr[i+1]=nums[i];
        dp = new int[n+1][n+1];
        for(int[] a: dp) Arrays.fill(a, -1);
        return fn(1,n,arr);
    }
    int fn(int i, int j, int[] arr){
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int maxi = -1;
        for(int idx=i; idx<=j; idx++){
            int cost = arr[i-1] * arr[idx] * arr[j+1] + 
                       fn(i, idx-1, arr) + fn(idx+1, j, arr);
            maxi = Math.max(maxi, cost);
        }
        return dp[i][j] = maxi;
    }
}