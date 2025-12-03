class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int cnt=0;
        int prev = Integer.MIN_VALUE;
        for(int num: nums){
            if(prev<num-k){
                prev=num-k;
                cnt++;
            }
            else if(prev<num+k){
                prev=prev+1;
                cnt++;
            }
        }
        return cnt;
    }
}