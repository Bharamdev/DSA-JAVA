class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int diff = Math.abs(nums[i]-nums[(i+1)%nums.length]);
            ans = Math.max(ans,diff);
        }
        return ans;
    }
}