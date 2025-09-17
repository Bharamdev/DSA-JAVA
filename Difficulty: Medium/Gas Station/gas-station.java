class Solution {
    public int startStation(int[] gas, int[] cost) {
        // code here
        int start=0;
        int diff=0;
        int tank=0;
        int total=0;
        for(int i=0;i<gas.length;i++){
            diff = gas[i]-cost[i];
            tank+=diff;
            total+=diff;
            if(tank<0){
                tank=0;
                start=i+1;
            }
        }
        return total >=0 ? start : -1;
    }
}