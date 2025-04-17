class Solution {
    public int countPairs(int[] nums, int k) {
        int cnt=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    int multiply = i*j;
                    if(multiply%k==0) cnt++;
                }
            }
        }
        return cnt;
    }
}