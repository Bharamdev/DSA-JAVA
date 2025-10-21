// User function Template for Java
class Solution {
    class pair{
        int dist;
        int node;
        pair(int dist, int node){
            this.dist = dist;
            this.node = node;
        }
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        List<List<pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int dist = edge[2];
            adj.get(u).add(new pair(dist,v));
        }
        // Topo Sort
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++){
            if(!vis[i]) topo(i, vis, adj, st);
        }
        int[] ans = new int[V];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[0]=0;
        while(!st.isEmpty()){
            int node = st.pop();
            if(ans[node]!=Integer.MAX_VALUE){
                for(pair it: adj.get(node)){
                   if(ans[node]+it.dist < ans[it.node]){
                       ans[it.node] = ans[node]+it.dist;
                   }
                }
            }
        }
        for(int i=0;i<V;i++){
            if(ans[i]==Integer.MAX_VALUE) ans[i]=-1;
        }
        return ans;
    }
    void topo(int node, boolean[] vis, List<List<pair>> adj,
    Stack<Integer> st){
        vis[node] = true;
        for(pair it: adj.get(node)){
            if(!vis[it.node]) topo(it.node, vis, adj, st);
        }
        st.push(node);
    }
}