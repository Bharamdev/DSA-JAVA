class Solution {
    public int maxProduct(int[] nums) {
        int prefix=1, suffix=1;
        int n= nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            prefix*=nums[i];
            suffix*=nums[n-1-i];
            max= Math.max(max, Math.max(suffix, prefix));
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;
            
        }
        return max;
    }
}