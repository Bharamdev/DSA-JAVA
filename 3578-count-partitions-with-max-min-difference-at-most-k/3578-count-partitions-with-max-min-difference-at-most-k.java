class Solution {
    public int countPartitions(int[] nums, int k) {
        int n=nums.length;
        long[] prefix = new long[n+1];
        long[] dp = new long[n+1];
        long mod = (long)1e9 + 7;
        dp[0]=1;
        prefix[0]=1;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int j=0;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(j<=i && map.lastKey() - map.firstKey() > k){
                map.put(nums[j], map.get(nums[j])-1);
                if(map.get(nums[j])==0) map.remove(nums[j]);
                j++;
            }
            long right = prefix[i];
            long left = j>0 ? prefix[j-1] : 0;
            dp[i+1] = (right-left)%mod;
            prefix[i+1] = (prefix[i]+dp[i+1])%mod;
        }
        return (int)dp[n];
    }
}