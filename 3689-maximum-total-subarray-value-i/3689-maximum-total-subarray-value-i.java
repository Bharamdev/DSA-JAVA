class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max = 0;
        long min = Long.MAX_VALUE;
        long ans=0;
        for(int num: nums){
            max = Math.max(max,num);
            min = Math.min(min,num);
        }
        return k*(max-min);
    }
}