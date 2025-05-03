class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n= nums.length;
        int i=0,j=n-1;
        int sum=0;
        while(i<j){
            sum=Math.max(sum,nums[i]+nums[j]);
            i++;
            j--;
        }
        return sum;
    }
}