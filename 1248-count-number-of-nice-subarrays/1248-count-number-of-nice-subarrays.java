class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int cnt=0,ans=0;
        int r=0,l=0;
        int a = help1(nums,k);
        int b = help2(nums,k-1);
        return a-b; 
    }
    public int help1(int[] nums, int k){
        int r=0,l=0,cnt=0,ans=0;
        while(r<nums.length){
            if(nums[r]%2!=0) cnt++;
            while(cnt>k){
                if(nums[l]%2!=0) cnt--;
                l++;
            }
            ans+=(r-l+1);
            r++;
        }
        return ans;
    }
    public int help2(int[] nums, int k){
        int r=0,l=0,cnt=0,ans=0;
        while(r<nums.length){
            if(nums[r]%2!=0) cnt++;
            while(cnt>k){
                if(nums[l]%2!=0) cnt--;
                l++;
            }
            ans+=(r-l+1);
            r++;
        }
        return ans;
    }
}