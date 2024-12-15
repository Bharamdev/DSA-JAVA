class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                return i;
            }
            else if(target>nums[i]){
                ans=i;
            }
            else{
                return i;
            }
        }
        return ans+1;
    }
}