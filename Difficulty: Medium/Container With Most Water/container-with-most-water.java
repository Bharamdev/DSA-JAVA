class Solution {
    public int maxWater(int arr[]) {
        // Code Here
        int n=arr.length;
        int maxArea = 0;
        int i=0,j=n-1;
        while(i<j){
            int area = (j-i)*(Math.min(arr[i],arr[j]));
            if(area>maxArea) maxArea = area;
            if(arr[j]>arr[i]) i++;
            else j--;
        }
        return maxArea;
    }
}