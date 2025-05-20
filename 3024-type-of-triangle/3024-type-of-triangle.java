class Solution {
    public String triangleType(int[] nums) {
        if(!istriangle(nums)) return "none";
        if(equilateral(nums)) return "equilateral";
        if(isosceles(nums)) return "isosceles";
        return "scalene";
    }
    public boolean istriangle(int[] nums){
        return nums[0]+nums[1]>nums[2] &&
               nums[1]+nums[2]>nums[0] &&
               nums[0]+nums[2]>nums[1];
    }
    public boolean equilateral(int[] nums){
        return nums[0]==nums[1] && nums[1]==nums[2];
    }
    public boolean isosceles(int[] nums){
        return nums[0]==nums[1] ||
               nums[1]==nums[2] ||
               nums[0]==nums[2];
    }

}