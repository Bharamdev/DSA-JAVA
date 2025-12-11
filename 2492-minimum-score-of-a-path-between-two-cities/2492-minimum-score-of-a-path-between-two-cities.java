class Solution {
    int min = Integer.MAX_VALUE;
    List<List<int[]>> adj;
    boolean[] vis;
    public int minScore(int n, int[][] roads) {
        adj= new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        vis = new boolean[n+1];
        for(int[] r: roads){
            int u=r[0],v=r[1],dist=r[2];
            adj.get(u).add(new int[]{v,dist});
            adj.get(v).add(new int[]{u,dist});
        }
        dfs(1,n);
        return min;
    }
    void dfs(int node, int n){
        // if(node==n) return;
        vis[node]=true;
        for(int[] it: adj.get(node)){
            int next = it[0];
            int dist = it[1];
            min = Math.min(min, dist);
            if(!vis[next]) dfs(next,n);
        }
    }
}