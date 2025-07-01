class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] rightsum = new long[n];
        long sum=nums[n-1];
        rightsum[0]=0;
        for(int i=n-1;i>0;i--){
            rightsum[i]=sum;
            sum+=nums[i-1];
        }
        sum=nums[0];
        int valid=0;
        for(int i=0;i<n-1;i++){
            if(sum>=rightsum[i+1]) valid++;
            sum+=nums[i+1];
        }
        return valid;
    }
}