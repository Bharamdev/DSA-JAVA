class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans=0;
        int n=nums.length;
        long sum=0;
        int r=0,l=0;
        while(r<n){
            sum+=nums[r];
            while((sum*(r-l+1)) >= k){
                sum-=nums[l];
                l++;
            }
            ans+= r-l+1;
            r++;
        } 
        return ans;
    }
}