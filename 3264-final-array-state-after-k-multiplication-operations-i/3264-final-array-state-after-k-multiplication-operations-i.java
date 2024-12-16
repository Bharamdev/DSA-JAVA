class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for(int i=0;i<k;i++){
            int min= Integer.MAX_VALUE;
            int minindex = -1;
            for(int j=0;j<nums.length;j++){
                if(nums[j]<min){
                    min=nums[j];
                    minindex=j;
                }
            }
            nums[minindex]= nums[minindex]*multiplier;
        }
        return nums;
    }
}