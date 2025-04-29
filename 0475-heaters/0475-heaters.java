class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int range=0;
        for(int house : houses){
            int minDist = Integer.MAX_VALUE;
            for(int heater:heaters){
                minDist = Math.min(minDist, Math.abs(house-heater));
            }
            range = Math.max(range,minDist);
        }
        return range;
    }
}