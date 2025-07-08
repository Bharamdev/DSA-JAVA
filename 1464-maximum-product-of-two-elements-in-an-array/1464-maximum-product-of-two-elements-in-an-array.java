class Solution {
    public int maxProduct(int[] nums) {
        // Arrays.sort(nums);
        // int n=nums.length;
        // return (nums[n-1]-1)*(nums[n-2]-1);
        int max=0,secmax=0;
        for(int num:nums){
            if(num>max){
                secmax=max;
                max=num;
            }
            else if(secmax<num) secmax=num;
        }
        return (secmax-1)*(max-1);
    }
}