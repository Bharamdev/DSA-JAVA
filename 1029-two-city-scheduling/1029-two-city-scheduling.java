class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        int[] arr = new int[n];
        int index=0,ans=0;
        for(int[] cost: costs ){
            arr[index++] = cost[1]-cost[0];
            ans+=cost[0];
        }
        Arrays.sort(arr);
        for(int i=0; i<n/2; i++){
            ans+= arr[i];
        }
        return ans;
    }
}