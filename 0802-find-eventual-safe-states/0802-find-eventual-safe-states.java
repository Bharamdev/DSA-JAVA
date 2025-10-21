class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] pathvis = new boolean[n];
        boolean[] check = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,graph,vis,pathvis,check);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(check[i]) ans.add(i);
        }
        return ans;
    }
    boolean dfs(int i, int[][] graph, boolean[] vis, boolean[] pathvis, boolean[] check){
        vis[i] = true;
        pathvis[i]=true;
        for(int node: graph[i]){
            if(!vis[node]){
                if(dfs(node, graph, vis, pathvis, check)) return true;
            }
            else if(pathvis[node]) return true;
        }
        check[i]=true;
        pathvis[i]=false;
        return false;
    }
}