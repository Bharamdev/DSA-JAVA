class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start=0;
        int product=1;
        int cnt=0;
        for(int end=0; end<nums.length; end++){
            product *= nums[end];
            while(product>=k && start<=end ){
                product /= nums[start];
                start++;
            }
            cnt += end-start+1;
        }
        return cnt;
    }
}