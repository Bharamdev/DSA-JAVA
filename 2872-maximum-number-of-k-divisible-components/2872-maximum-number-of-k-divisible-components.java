class Solution {
    ArrayList<ArrayList<Integer>> adj;
    int ans=0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        } 
        dfs(0,-1,values,k);
        return ans;
    }
    long dfs(int node, int parent,int[] values, int k){
        long sum = values[node];
        for(int it: adj.get(node)){
            if(it==parent) continue;
            sum += dfs(it, node, values, k);
        }
        if(sum%k==0){
            ans++;
            return 0;
        }
        return  sum%k;
    }
}