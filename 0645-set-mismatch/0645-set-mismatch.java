class Solution {
    public int[] findErrorNums(int[] nums) {
        // int[] ans = {-1,-1};
        int i = 0;
        int n =nums.length;
        while(i<n){
            if(nums[i] != nums[nums[i]-1]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i]= temp;
            }
            else{
                i++;
            }
        }
        for(int j=0;j<n;j++){
            if(nums[j] != j+1){
                return new int[] {nums[j], j+1};
            }
        }
        return new int[] {-1,-1};
    }
}