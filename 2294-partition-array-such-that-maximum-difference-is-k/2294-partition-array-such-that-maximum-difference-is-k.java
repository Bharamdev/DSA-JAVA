class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0,j=0,cnt=0;
        while(j<nums.length && i<nums.length){
            if(nums[j]-nums[i]<=k) j++;
            else if(nums[j]-nums[i]>k){
                cnt++;
                i=j;
            }
        }
        return cnt+1;
    }
}