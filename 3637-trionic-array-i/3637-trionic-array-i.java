class Solution {
    public boolean isTrionic(int[] nums) {
        int n=nums.length;
        int i=1;
        while(i<n && nums[i]>nums[i-1]) i++;
        if(i==1 || i==n) return false;
        int afterup = i;
        while(i<n && nums[i]<nums[i-1]) i++;
        if(i==afterup || i==n) return false;
        int afterdown =i;
        while(i<n && nums[i]>nums[i-1]) i++;
        if(i==afterdown) return false;

        return i==n;
    }
}