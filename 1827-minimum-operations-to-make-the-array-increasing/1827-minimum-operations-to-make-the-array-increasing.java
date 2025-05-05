class Solution {
    public int minOperations(int[] nums) {
        int cnt=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=nums[i-1]){
                int diff = nums[i-1]-nums[i];
                nums[i]+=diff+1;
                cnt+= diff+1;
            }
        }
        return cnt;
    }
}