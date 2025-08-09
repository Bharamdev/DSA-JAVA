class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total=0;
        for(int num: nums) total+=num;
        int diff = total-target;
        if(diff<0 || diff%2!=0) return 0;
        int sum = diff/2;
        return TotalSum(nums,sum);
    }
    public int TotalSum(int[] nums, int sum){
        int n = nums.length;
        int[][] dp = new int[n+1][sum+1];
        for(int i=0;i<=n;i++) dp[i][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(j-nums[i-1]>=0){
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}