class Solution {
    public int missingNumber(int[] nums) {
        int n= nums.length;
        int i=0;
        while(i<n){
            if(nums[i]<n && nums[i] != nums[nums[i]]){
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
            else{
                i++;
            }
        }
        for(int j=0;j<n;j++){
            if(nums[j]!=j){
                return j;
            }
        }
        return n;
    }
}