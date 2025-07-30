class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for(int num: nums){
            if(num>max) max=num;
        }
        int len=0,res=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==max){
                len++;
                res = Math.max(res,len);
            }
            else{
                len=0;
            } 
        }
        return res;
    }
}