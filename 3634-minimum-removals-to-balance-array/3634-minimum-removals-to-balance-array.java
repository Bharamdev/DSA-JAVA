class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int len=0;
        int l=0;
        for(int r=0;r<nums.length;r++){
            while((long)nums[r]>(long)nums[l]*k){
                l++;
            }
            len = Math.max(len, r-l+1);
        }
        return nums.length-len;
    }
}