class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int r=k-1,l=0;
        double max = Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<k-1;i++) sum+=nums[i];
        while(r<nums.length){
            sum+=nums[r];
            double avg = (double)sum/k;
            max=Math.max(max,avg);
            r++;
            sum-=nums[l];
            l++;
        }
        return max;
    }
}