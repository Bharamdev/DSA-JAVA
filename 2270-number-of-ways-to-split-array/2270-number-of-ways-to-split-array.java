class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long rightsum = 0;
        long leftsum = 0;
        for(int i=n-1;i>=0;i--){
            rightsum+=nums[i];
        }
        int valid=0;
        for(int i=0;i<n-1;i++){
            leftsum += nums[i];
            rightsum-=nums[i];
            if(leftsum>=rightsum) valid++;
        }
        return valid;
    }
}