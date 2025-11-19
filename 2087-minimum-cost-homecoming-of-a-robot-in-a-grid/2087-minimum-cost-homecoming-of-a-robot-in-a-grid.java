class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int cost = 0;
        int sr = startPos[0], sc = startPos[1];
        int hr = homePos[0], hc = homePos[1];
        while(sr!=hr){
            if(sr<hr) sr++;
            else sr--;
            cost+=rowCosts[sr];
        }
        while(sc!=hc){
            if(sc<hc) sc++;
            else sc--;
            cost+=colCosts[sc];
        }
        return cost;
    }
}