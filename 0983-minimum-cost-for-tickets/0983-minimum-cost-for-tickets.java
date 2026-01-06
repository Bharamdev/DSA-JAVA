class Solution {
    int n;
    int[] memo;
    public int mincostTickets(int[] days, int[] costs) {
        n = days.length;
        memo = new int[n];
        return dfs(0, days, costs);
    }
    int dfs(int idx, int[] days, int[] costs){
        if(idx>=n) return 0;
        if(memo[idx] != 0) return memo[idx];
        // one day
        int cost1 = costs[0] + dfs(idx+1, days, costs);
        // 7 days
        int j=idx;
        while(j<n && days[j]<days[idx]+7) j++;
        int cost7 = costs[1] + dfs(j, days, costs);
        // 30 days;
        j=idx;
        while(j<n && days[j]<days[idx]+30) j++;
        int cost30 = costs[2] + dfs(j, days, costs);
        memo[idx] = Math.min(cost1, Math.min(cost7, cost30));
        return memo[idx];
    }
}