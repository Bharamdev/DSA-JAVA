class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int j=0,cnt=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[j]){
                cnt++;
                j++;
            }
        }
        return cnt;
    }
}