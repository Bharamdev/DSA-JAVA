class Solution {
    public int maximumDifference(int[] nums) {
        int ans=-1;
        int min = nums[0];
        for(int j=1;j<nums.length;j++){
            if(nums[j]>min){
                ans=Math.max(ans,nums[j]-min);
            }
            min = Math.min(min,nums[j]);
        }
        return ans;
    }
}