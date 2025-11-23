class Solution {
    public int maxSumDivThree(int[] nums) {
        // return solve(0,0,nums);
        int n = nums.length;
        int[][] dp = new int[n+1][3];
        dp[n][0]=0;
        dp[n][1]=Integer.MIN_VALUE;
        dp[n][2]=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            for(int rem=0; rem<=2; rem++){
                int newrem = (nums[i]+rem)%3;
                int take = dp[i+1][newrem]==Integer.MIN_VALUE ?
                           Integer.MIN_VALUE : nums[i] + dp[i+1][newrem];
                int notTake = dp[i+1][rem];
                dp[i][rem] = Math.max(take,notTake);
            }
        }
        return dp[0][0];
    }

    // Recursion
    // int solve(int i, int rem, int[] nums){
    //     if(i>=nums.length){
    //         if(rem==0) return 0;
    //         return Integer.MIN_VALUE;
    //     }
    //     int take = nums[i] + solve(i+1, (rem+nums[i])%3, nums);
    //     int notTake = solve(i+1,rem, nums);
    //     return Math.max(take, notTake);
    // }
}