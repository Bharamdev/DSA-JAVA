class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int cnt=0;
        int ele=Integer.MAX_VALUE;
        for(int i=nums.length-1; i>=0;i--){
            if(ele!=nums[i]){
                cnt++;
                ele=nums[i];
            }
            if(cnt==3) return nums[i];
        }
        return nums[nums.length-1];
    }
}