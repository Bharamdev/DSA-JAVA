class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long cnt=1;
        int j=0;
        for(int i=1;i<n;i++){
            if(prices[i-1]-prices[i] == 1){
                cnt+=i-j+1;
            }
            else{
                j=i;
                cnt+=1;
            }
        }
        return cnt;
    }
}