class Solution {
    public int longestSubarray(int[] nums) {
        int cnt=0,res=0;
        int zero=0;
        int n=nums.length;
        int l=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1) cnt++;
            else zero++;
            while(zero>1){
                if(nums[l]==0) zero--;
                else cnt--;
                l++;
            }
            res=Math.max(res,cnt);
        }
        return res!=n ? res : res-1;
    }
}