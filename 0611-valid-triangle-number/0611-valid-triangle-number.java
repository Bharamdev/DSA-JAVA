class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int cnt=0;
        int n = nums.length;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i]+nums[j] > nums[k]) cnt++;
                }
            }
        }
        return cnt;
    }
}