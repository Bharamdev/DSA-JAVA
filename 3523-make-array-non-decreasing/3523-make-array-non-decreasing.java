class Solution {
    public int maximumPossibleSize(int[] nums) {
        int i=0,len=0,prev=nums[0];
        while(i<nums.length){
            if(nums[i]>=prev){
                prev=nums[i];
                len++;
                i++;
            }
            else{
                while(i<nums.length && nums[i]<prev){
                    i++;
                }
            }
        }
        return len;
    }
}