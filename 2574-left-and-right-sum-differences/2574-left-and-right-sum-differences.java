class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            left[i] = sum;
            sum+=nums[i];
        }
        sum=0;
        for(int i=n-1;i>=0;i--){
            right[i] = sum;
            sum+=nums[i];
        }
        for(int i=0;i<n;i++){
            ans[i] = Math.abs(left[i]-right[i]);
        }
        return ans;
    }
}