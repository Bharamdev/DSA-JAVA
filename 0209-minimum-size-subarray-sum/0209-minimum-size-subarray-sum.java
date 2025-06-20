class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int r=0,l=0;
        int len=Integer.MAX_VALUE,sum=0;
        while(r<nums.length){
            sum+=nums[r];
            while(sum>=target){
                len=Math.min(len, r-l+1);
                sum-=nums[l];
                l++;
            }
            r++;
        }
        return len!=Integer.MAX_VALUE ? len : 0;
    }
}