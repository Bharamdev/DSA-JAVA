class Solution {
    public int minimumCost(int[] nums) {
        int sum=Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                sum = Math.min(sum, nums[0]+nums[i]+nums[j]);
            }
        }
        return sum;
    }
}