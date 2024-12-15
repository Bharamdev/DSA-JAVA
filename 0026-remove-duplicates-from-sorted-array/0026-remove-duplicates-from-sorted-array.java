class Solution {
    public int removeDuplicates(int[] nums) {
        int ans=Integer.MIN_VALUE,j=0;
        for(int num: nums){
            if(num!=ans){
                nums[j]=num;
                ans=num;
                j++;
            }
           
        }   
        return j;
    }
}