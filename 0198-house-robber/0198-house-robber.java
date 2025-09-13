class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n];
        dp[0]=nums[0];
        int notTake=0;
        int take=0;
        for(int i=1;i<n;i++){
            notTake = dp[i-1];
            take = nums[i];
            if(i>=2) take+=dp[i-2]; 
            dp[i] = Math.max(notTake, take);
        }
        return dp[n-1];
    }
}