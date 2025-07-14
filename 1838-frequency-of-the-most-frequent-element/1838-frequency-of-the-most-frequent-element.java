class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long sum=0;
        int n=nums.length;
        int r=1,l=0,res=1;
        while(r<n){
            sum+=  (long)(r-l)*(nums[r]-nums[r-1]);
            while(sum>k){
                sum-=nums[r]-nums[l];
                l++;
            }
            res=Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
}