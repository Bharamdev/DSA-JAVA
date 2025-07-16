class Solution {
    public int jump(int[] nums) {
        int maxJump=0;
        int end=0;
        int jumps=0;
        int n=nums.length;
        for(int i=0;i<nums.length-1;i++){
            maxJump = Math.max(maxJump,nums[i]+i);
            if(end==i){
                end=maxJump;
                jumps++;
            }
        }
        return jumps;
    }
}