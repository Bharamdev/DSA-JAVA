class Solution {
    public int maxBalancedShipments(int[] weight) {
        int cnt=0;
        for(int i=1;i<weight.length;i++){
            if(weight[i]<weight[i-1]) {
                cnt++;
                i++;
            }
        }
        return cnt;
    }
}