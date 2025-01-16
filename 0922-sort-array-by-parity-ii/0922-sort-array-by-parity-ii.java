class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int[] arr = new int[nums.length];
        int e=0,o=1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2==0){
                arr[e]=nums[i];
                e=e+2;
            }
            else{
                arr[o]=nums[i];
                o=o+2;
            }
        }
        return arr;
    }
}