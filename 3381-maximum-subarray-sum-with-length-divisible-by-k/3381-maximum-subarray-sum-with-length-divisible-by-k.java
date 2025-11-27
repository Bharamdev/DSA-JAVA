class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long pre = 0;
        long[] min = new long[k];
        Arrays.fill(min, Long.MAX_VALUE);
        min[0]=0;
        long ans = Long.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            pre+=nums[i];
            int rem = (i + 1) % k;
            if(min[rem] != Long.MAX_VALUE){
                ans = Math.max(ans, pre-min[rem]);
            }
            min[rem] = Math.min(min[rem], pre);
        }
        return ans;
    }
}