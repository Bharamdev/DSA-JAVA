class Solution {
    int ans;
    ArrayList<ArrayList<Integer>> adj;
     int[] depth;
    public int findShortestCycle(int n, int[][] edges) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] vis = new boolean[n];
        int[] parent = new int[n];
        depth = new int[n];
        Arrays.fill(parent,-1);
        ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(!vis[i]) dfs(i,0,vis,parent);
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
    void dfs(int node, int d, boolean[] vis, int[] parent){
        vis[node]=true;
        depth[node]=d;
        for(int it: adj.get(node)){
            if(!vis[it]){
                parent[it]=node;
                dfs(it, d+1, vis, parent);
            }
            else if(parent[node]!=it){
                ans = Math.min(ans, Math.abs(depth[node]-depth[it])+1);
            }
        }
    }
}