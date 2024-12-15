class Solution {
    public int removeElement(int[] nums, int val) {
        int ans=0;
        for(int num:nums){
            if(num!=val){
                nums[ans]=num;
                ans++;
            }
        }
        return ans;
    }
}