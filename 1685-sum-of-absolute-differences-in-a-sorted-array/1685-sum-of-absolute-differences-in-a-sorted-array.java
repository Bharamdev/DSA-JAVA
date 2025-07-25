class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n=nums.length;
        long rightSum=0,leftSum=0;
        for(int num:nums) rightSum+=(long)num;
        int[] res = new int[n];
        int diff = 0;
        for(int i=0;i<n;i++){
            rightSum-=(long)nums[i];
            long rightDiff = Math.abs(leftSum-(i*nums[i]));
            long leftDiff = Math.abs(rightSum-(nums[i]*(n-1-i)));
            diff = (int)(rightDiff + leftDiff);
            res[i]=diff;
            leftSum+=(long)nums[i];
        }
        return res;
    }
}