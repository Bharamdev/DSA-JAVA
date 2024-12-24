class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int mini = Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            mini = Math.min(mini,nums[i]);
        }
        int ans= sum - (n*mini);
        return ans ;
    }
}