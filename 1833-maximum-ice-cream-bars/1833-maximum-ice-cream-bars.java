class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int cnt=0;
        long sum=0;
        for(int cost: costs){
            sum+=cost;
            if(sum<=coins) cnt++;
            else break;
        }
        return cnt;
    }
}