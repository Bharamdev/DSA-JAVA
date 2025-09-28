class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        for(int k=n-1;k>=2;k--){
            if(nums[k-1]+nums[k-2] > nums[k])
              return nums[k]+nums[k-1]+nums[k-2];
        }
        return 0;
    }
}