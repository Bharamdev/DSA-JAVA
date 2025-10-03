class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        int ans=0,maxi=0;
        for(int i=0;i<n;i++){
            dp[i]=1;
            cnt[i]=1;
            for(int prev=0;prev<i;prev++){
                if(nums[i]>nums[prev] && dp[prev]+1>dp[i]){
                    dp[i]=1+dp[prev];
                    cnt[i]=cnt[prev];
                }
                else if(dp[prev]+1==dp[i]) cnt[i]+=cnt[prev];
            }
            if(dp[i]>maxi){
                maxi=dp[i];
                ans=cnt[i];
            }
            else if(dp[i]==maxi) ans+=cnt[i];
        }
        return ans;
    }
}