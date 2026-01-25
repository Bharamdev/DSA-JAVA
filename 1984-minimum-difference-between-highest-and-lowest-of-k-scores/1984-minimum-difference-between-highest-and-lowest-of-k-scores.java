class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l=0,r=k-1;
        int min=Integer.MAX_VALUE;
        while(r<n){
            min = Math.min(min, nums[r]-nums[l]);
            r++;
            l++;
        }
        return min;
    }
}