class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        for(int num: nums) xor^=num;
        int n=nums.length;
        if(xor!=0) return n;
        for(int i=0;i<n;i++){
            xor^=nums[i];
            if(xor!=0) return n-i-1; 
        }
        return 0;
    }
}