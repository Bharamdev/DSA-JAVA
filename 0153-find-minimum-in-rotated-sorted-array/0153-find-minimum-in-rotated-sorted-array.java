class Solution {
    public int findMin(int[] nums) {
        int start=0, end= nums.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(end>mid && nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if(start<mid && nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            if(nums[end]>nums[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return nums[0];
    }
}