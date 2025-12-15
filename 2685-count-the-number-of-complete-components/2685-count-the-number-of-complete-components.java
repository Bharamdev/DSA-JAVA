class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    boolean[] vis;
    public int countCompleteComponents(int n, int[][] edges) {
        vis = new boolean[n];
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                int[] comp = new int[2];
                dfs(i, comp);
                int nodes = comp[0];
                int totalE = comp[1]/2;
                if(totalE == (nodes*(nodes-1))/2) cnt++;
            }
        }
        return cnt;
    }
    void dfs(int node, int[] comp){
        vis[node]=true;
        comp[0]+=1;                        // No. of nodes
        comp[1] += adj.get(node).size();       // no. of edges
        for(int it: adj.get(node)){
            if(!vis[it]){
                dfs(it, comp);
            }
        }
    }
}