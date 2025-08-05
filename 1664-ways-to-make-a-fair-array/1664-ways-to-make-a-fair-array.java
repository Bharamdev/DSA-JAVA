class Solution {
    public int waysToMakeFair(int[] nums) {
        int odd=0,even=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0) even+=nums[i];
            else odd+=nums[i];
        }
        int cnt=0;
        int newOdd=0,newEven=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0) even-=nums[i];
            else odd-=nums[i];
            if(even+newOdd == odd+newEven) cnt++;
            if(i%2==0) newEven+=nums[i];
            else newOdd+=nums[i];
        }
        return cnt;
    }
}