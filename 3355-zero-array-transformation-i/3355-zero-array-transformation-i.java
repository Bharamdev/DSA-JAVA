class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        int[] diff = new int[n+1];
        for(int[] q: queries){
            diff[q[0]]++;
            if(q[1]+1<n) diff[q[1]+1]--;
        }
        int decrement=0;
        for(int i=0;i<n;i++){
            decrement+=diff[i];
            if(nums[i]>decrement) return false;
        }
        return true;
    }
}