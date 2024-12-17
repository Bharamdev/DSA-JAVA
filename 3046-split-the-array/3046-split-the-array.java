class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int n = nums.length;
        int[] num1 = new int[1000];
        for(int i=0;i<n;i++){
            num1[nums[i]]++;
        }
        for(int i=0;i<num1.length;i++){
            if(num1[i]>2) return false;
           
        }
        return true;
       
    }
}