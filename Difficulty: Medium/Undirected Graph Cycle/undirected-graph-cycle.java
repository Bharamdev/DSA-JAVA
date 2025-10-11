class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] arr: edges ){
            int u = arr[0];
            int v = arr[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(i,-1,adj,vis)) return true;
            }
        }
        return false;
    }
    
    boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj,
            boolean[] vis){
            
            vis[node] = true;
            for(int i: adj.get(node)){
                if(!vis[i]){
                    if(dfs(i,node,adj,vis)) return true;
                }
                else{
                    if(i != parent) return true;
                }
            }
            return false;
    }
}