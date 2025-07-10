class Solution {
    public int minIncrementForUnique(int[] nums) {
        int moves=0;
        Arrays.sort(nums);
        if(nums.length==1) return 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=nums[i-1]){
                int needed = nums[i-1]+1;
                moves += needed-nums[i];
                nums[i]=needed; 
                
            }
        }
        return moves;
    }
}