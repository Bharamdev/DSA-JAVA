class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n<=1) return nums[0];
        int[] first = new int[n-1];
        for(int i=0;i<n-1;i++) first[i] = nums[i];
        int[] last = new int[n-1];
        for(int i=1;i<n;i++) last[i-1]=nums[i];
        return Math.max( houseRobber(first, n-1), houseRobber(last, n-1) );
    }
    int houseRobber(int[] arr, int n){
        int[] dp = new int[n];
        int notTake=0, take=0;
        dp[0] = arr[0];
        for(int i=1;i<n;i++){
            notTake = dp[i-1];
            take = arr[i];
            if(i>=2) take += dp[i-2];
            dp[i] = Math.max(notTake, take);
        } 
        return dp[n-1];
    }
}