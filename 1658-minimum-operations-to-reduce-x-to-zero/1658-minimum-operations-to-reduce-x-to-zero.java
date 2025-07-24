class Solution {
    public int minOperations(int[] nums, int x) {
        int n= nums.length;
        int sum=0;
        for(int num:nums) sum+=num;
        int target = sum-x;
        if(target<0) return -1;
        int maxlen=-1,l=0;
        sum=0;
        for(int r=0;r<n;r++){
            sum+=nums[r];
            while(sum>target){
                sum-=nums[l++];
            }
            if(sum==target) maxlen = Math.max(maxlen,r-l+1);
        }
        return maxlen==-1 ? -1 : n-maxlen;
    }
}