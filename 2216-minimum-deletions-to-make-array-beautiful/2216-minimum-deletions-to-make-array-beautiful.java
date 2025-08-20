class Solution {
    public int minDeletion(int[] nums) {
        int n=nums.length;
        int place=0;
        int cnt=0;
        for(int i=0;i<n-1;i++){
            if((place+i)%2==0 && nums[i]==nums[i+1]){
                cnt++;
                place++;
            }
        }
        if((n-cnt)%2!=0) cnt++;
        return cnt;
    }
}