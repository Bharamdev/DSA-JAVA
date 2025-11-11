class Solution {
    boolean[] vis;
    int[] arr;
    int[] low;
    List<List<Integer>> bridge;
    int timer=1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(List<Integer> it: connections){
            int u = it.get(0);
            int v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        vis = new boolean[n];
        arr = new int[n];
        low = new int[n];
        bridge = new ArrayList<>();
        dfs(0,-1,adj);
        return bridge;
    }
    void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj){
        vis[node]=true;
        arr[node]=timer;
        low[node]=timer;
        timer++;
        for(int it: adj.get(node)){
            if(it==parent) continue;
            if(!vis[it]){
                dfs(it,node,adj);
                low[node] = Math.min(low[node], low[it]);
                if(low[it] > arr[node]) bridge.add(Arrays.asList(node,it));
            }
            else{
                low[node] = Math.min(low[node],low[it]);
            }
        }
    }
}