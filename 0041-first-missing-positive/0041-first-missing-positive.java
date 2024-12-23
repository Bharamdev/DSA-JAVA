class Solution {
    public int firstMissingPositive(int[] nums) {
        int n= nums.length;
        int i=0;
        while(i<n){
            if(nums[i] > 0 && nums[i]<=n && nums[i] != nums[nums[i]-1] ){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
            else{
                i++;
            }
        }
        for(int j=0;j<n;j++){
            if(nums[j] != j+1){
                return j+1;
            }
        }
        return n+1;
    }
}