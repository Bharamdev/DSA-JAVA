class Solution {
    public int trap(int[] height) {
        int[] LMax = new int[height.length];
        int[] RMax = new int[height.length];
        int maxi1=-1, maxi2=-1;
        int mini,ans=0;
        for(int i=0; i<height.length; i++){
            maxi1 = Math.max(maxi1, height[i]);
            LMax[i] = maxi1;
        }
        for(int i=height.length-1; i>=0; i--){
            maxi2 = Math.max(maxi2, height[i]);
            RMax[i] = maxi2;
        }
        for(int i=0; i<height.length; i++){
           mini = Math.min(LMax[i],RMax[i]);
           ans += mini - height[i];
        }
        return ans;
    }
}