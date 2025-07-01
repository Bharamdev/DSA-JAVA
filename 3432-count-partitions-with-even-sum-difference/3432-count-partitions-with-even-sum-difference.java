class Solution {
    public int countPartitions(int[] nums) {
        int rightsum=0,leftsum=0;
        for(int i: nums) rightsum+=i;
        int cnt=0;
        for(int i=0;i<nums.length-1;i++){
            leftsum+=nums[i];
            rightsum-=nums[i];
            if((rightsum-leftsum)%2==0) cnt++;
        }
        return cnt;
    }
}