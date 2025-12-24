class Solution {
    List<List<Integer>> adj;
    boolean[] vis;
    int maxDist;
    int farNode;
    public int diameter(int V, int[][] edges) {
        // Code here
        adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        vis = new boolean[V];
        dfs(0, 0);            // find farthest from any node (0)
        int start=farNode;
        vis = new boolean[V];
        dfs(start,0);         // find farthest from start
        return maxDist;
    }
    void dfs(int node, int dist){
        vis[node]=true;
        if(dist>maxDist){
            maxDist=dist;
            farNode=node;
        }
        for(int it: adj.get(node)){
            if(!vis[it]){
                dfs(it, dist+1);
            }
        }
    }
}