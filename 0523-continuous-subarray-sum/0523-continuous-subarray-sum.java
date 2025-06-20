class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            int sum=nums[i];
            for(int j=i+1;j<nums.length;j++){
                sum+=nums[j];
                if(sum%k==0) return true;
            }
        }
        return false;
    }
}