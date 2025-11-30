class Solution {
    public int countElements(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        if(k==0) return n;
        int cnt=0;
        int same=0;
        for(int i=n-2;i>=0;i--){
            if(nums[i]!=nums[i+1] && n-1-i >= k){
                cnt++;
                same=0;
            }
            else if(nums[i]==nums[i+1]){
                same++;
                int len = n-1-i-same;
                if(len>=k) cnt++;
            }
        }
        return cnt;
    }
}