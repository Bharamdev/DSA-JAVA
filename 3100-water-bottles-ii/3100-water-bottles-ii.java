class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int full = 0, empty=numBottles, total=numBottles;
        while(full+empty >= numExchange){
            while(numExchange <= empty){
                full++;
                empty-=numExchange;
                numExchange++;
            }
            total+=full;
            empty+=full;
            full=0;
        }
        return total;
    }
}