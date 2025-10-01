class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int cnt=numBottles;
        while(numBottles >= numExchange){
            cnt+= numBottles/numExchange;
            numBottles = (numBottles/numExchange) + (numBottles%numExchange);
        }
        return cnt;
    }
}