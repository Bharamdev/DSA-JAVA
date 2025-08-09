class Solution {
    public long countSubarrays(int[] nums, int k) {
        long res=0;
        long cnt = 0;
        int l=0;
        int max=0;
        for(int num:nums){
            if(num>max) max=num;
        }
        for(int r=0;r<nums.length;r++){
            if(nums[r]==max) cnt++;
            while(cnt>=k){
                if(nums[l]==max) cnt--;
                l++;
            }
            res+=l;
        }
        return res;
    }
}