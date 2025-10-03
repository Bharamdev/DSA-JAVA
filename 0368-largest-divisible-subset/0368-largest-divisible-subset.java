class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        int maxi=0;
        int idx=0;
        for(int i=0;i<n;i++){
            dp[i]=1;
            hash[i]=i;
            for(int prev=0;prev<i;prev++){
                if(nums[i]%nums[prev]==0 && dp[prev]+1 > dp[i]){
                    dp[i] = 1+dp[prev];
                    hash[i]=prev;
                }
                if(dp[i]>maxi){
                    maxi=dp[i];
                    idx=i;
                }
            }
        }
        List<Integer> arr = new ArrayList<>();
        arr.add(nums[idx]);
        while(idx!=hash[idx]){
            idx=hash[idx];
            arr.add(nums[idx]);
        }
        return arr;
    }
}