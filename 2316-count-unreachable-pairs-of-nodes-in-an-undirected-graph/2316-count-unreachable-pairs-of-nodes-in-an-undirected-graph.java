class Solution {
    boolean[] vis;
    List<List<Integer>> adj;
    int cnt;
    public long countPairs(int n, int[][] edges) {
        vis = new boolean[n];
        adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        long ans=0,total=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                cnt=0;
                dfs(i);
                ans+=(total*cnt);
                total+=cnt;
            }
        }
        return ans;
    }
    void dfs(int node){
        vis[node]=true;
        cnt++;
        for(int it: adj.get(node)){
            if(!vis[it]) dfs(it);
        }
    }
}