class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int max=0,min=0;
        int n = nums.length;
        for(int i=0;i<k;i++){
            min+=nums[i];
            max+=nums[n-1-i];
        }
        return max-min;
    }
}