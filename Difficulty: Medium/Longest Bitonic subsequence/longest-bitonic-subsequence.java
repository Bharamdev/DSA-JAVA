
class Solution {
    public static int LongestBitonicSequence(int n, int[] nums) {
        // code here
        int[] inc = incFn(n, nums);
        int[] dec = decFn(n, nums);
        int maxi=0;
        for(int i=0;i<n;i++){
            if(inc[i]>1 && dec[i]>1){
                maxi = Math.max(maxi, inc[i]+dec[i]-1);
            }
        }
        return maxi;
    }
    static int[] incFn(int n, int[] nums){
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int prev=0;prev<i;prev++){
                if(nums[i]>nums[prev] && dp[prev]+1 > dp[i] ){
                    dp[i] = dp[prev]+1;
                }
            }
        }
        return dp;
    }
    static int[] decFn(int n, int[] nums){
        int[] dp = new int[n];
        for(int i=n-1;i>=0;i--){
            dp[i]=1;
            for(int prev=n-1;prev>i;prev--){
                if(nums[i]>nums[prev] && dp[prev]+1 > dp[i] ){
                    dp[i] = dp[prev]+1;
                }
            }
        }
        return dp;
    }
}
