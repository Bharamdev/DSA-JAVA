class Solution {
    public int minSwaps(int[] nums) {
        int totalOne = 0;
        int cnt=0, maxOne=Integer.MIN_VALUE;
        int n=nums.length;
        for(int num: nums) {
            if(num==1) totalOne++;
        }
        for(int i=0;i<totalOne;i++){
            if(nums[i]==1) cnt++;
        }
        for(int i=totalOne; i < n + totalOne; i++){
            if(nums[i%n]==1) cnt++;
            if(nums[i-totalOne]==1) cnt--;
            maxOne = Math.max(maxOne, cnt);
        }
        return totalOne-maxOne;
    }
}