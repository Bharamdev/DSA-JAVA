class Solution {
    boolean[] vis;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        vis = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        dfs(source, adj, destination);
        return vis[source] && vis[destination];
    }
    void dfs(int s, List<List<Integer>> adj, int d){
        vis[s]=true;
        if(vis[d]) return;
        for(int it: adj.get(s)){
            if(!vis[it]) dfs(it, adj, d);
        }
    }
}