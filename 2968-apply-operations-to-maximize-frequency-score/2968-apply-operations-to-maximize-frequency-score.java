class Solution {
    public int maxFrequencyScore(int[] nums, long k) {
        Arrays.sort(nums);
        int maxLen=0;
        int l=0;
        long sum=0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r]-nums[(r+l)/2];
            while(sum > k){
                sum-= nums[(r+l+1)/2]-nums[l];
                l++;
            } 
            maxLen = Math.max(maxLen,r-l+1);
        }
        return maxLen;
    }
}