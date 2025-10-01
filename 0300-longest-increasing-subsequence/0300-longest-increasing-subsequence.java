class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxi=0;
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int prev=0;prev<i;prev++){
                if(nums[prev] < nums[i] && dp[prev]+1 > dp[i]){
                    dp[i] = dp[prev]+1;
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }
}