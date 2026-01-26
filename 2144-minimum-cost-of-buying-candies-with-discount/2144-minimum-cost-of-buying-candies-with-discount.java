class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        if(n==1) return cost[0];
        int sum=0;
        for(int i=n-1;i>=0;i--){
            if((n-1-i)%3 != 2) sum+=cost[i];
        }
        return sum;
    }
}