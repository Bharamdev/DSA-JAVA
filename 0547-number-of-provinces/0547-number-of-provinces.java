class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int u=0;u<n;u++){
            for(int v=0;v<n;v++){
                if(u!=v && isConnected[u][v]==1){
                    adj.get(u).add(v);
                    adj.get(v).add(u);
                }
            }
        }
        boolean[] vis = new boolean[n];
        int provinces=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i, vis, adj);
                provinces++;
            }
        }
        return provinces;
    }
    void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node]=true;
        for(int nodes: adj.get(node)){
            if(!vis[nodes]){
                vis[nodes] = true;
                dfs(nodes, vis, adj);
            }
        }
    }
}