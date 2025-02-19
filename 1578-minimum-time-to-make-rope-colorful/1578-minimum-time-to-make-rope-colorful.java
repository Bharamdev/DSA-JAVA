class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n= neededTime.length;
        int sum=0, maxTime= neededTime[0];
        for(int i=1; i<n;i++){
            if(colors.charAt(i) != colors.charAt(i-1)){
                maxTime = neededTime[i];
            }
            else{
                sum+=Math.min(maxTime, neededTime[i]);
                maxTime=Math.max(maxTime,neededTime[i]);
            }
        }
        return sum;
    }
}