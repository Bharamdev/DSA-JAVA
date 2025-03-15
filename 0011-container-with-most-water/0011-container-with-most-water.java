class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i=0, j=n-1,water=0;
        while(i<j){
            int h=Math.min(height[i],height[j]);
            int area = (j-i)*h;
            water=Math.max(water,area);
            if(height[i]<height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return water;
    }
}