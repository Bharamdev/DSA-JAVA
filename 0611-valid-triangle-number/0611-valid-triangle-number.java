class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int cnt=0;
        int n = nums.length;
        for(int k=n-1;k>=2;k--){
            int i=0, j=k-1;
            while(i<j){
                if(nums[i]+nums[j] > nums[k]){
                    // All are valid i,i+1,i+2....j-1 with j
                    cnt+=(j-i);
                    j--;
                }
                else{
                    // Bigger the number
                    i++;
                }
            }
        }
        return cnt;
    }
}