class Solution {
    public int maxProduct(int[] nums) {
        int prefix=1, suffix=1;
        int n= nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            prefix*=nums[i];
            suffix*=nums[n-1-i];
            if(nums[i]==0) return 0;
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;
            max= Math.max(max, Math.max(suffix, prefix));
        }
        return max;
    }
}