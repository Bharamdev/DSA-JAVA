class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n=nums.size();
        for(int i=0; i+(2*k)<=n; i++){
            if(fn(nums, i, i+k-1) && fn(nums, i+k, i+(2*k)-1)) return true;
        }
        return false;
    }
    boolean fn(List<Integer> nums, int s, int e){
        for(int i=s+1;i<=e;i++){
            if(nums.get(i)<=nums.get(i-1)) return false;
        }
        return true;
    }
}