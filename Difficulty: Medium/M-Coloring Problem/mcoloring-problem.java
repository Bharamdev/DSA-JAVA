class Solution {
    int[] color;
    boolean[][] adj;
    int n;
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        adj = new boolean[v][v];
        n=v;
        for(int[] e: edges){
            adj[e[0]][e[1]] = true;
            adj[e[1]][e[0]] = true;
        }
        color = new int[v];
        return dfs(0,m);
    }
    boolean dfs(int node, int m){
        if(node==n){
            return true;
        }
        for(int col=1; col<=m; col++){
            if(isSafe(node, col, m)){
                color[node]=col;
                if(dfs(node+1, m)) return true;
                color[node]=0;
            }
        }
        return false;
    }
    boolean isSafe(int node, int col, int m){
        for(int i=0;i<n;i++){
            if(adj[node][i] && color[i]==col) return false;
        }
        return true;
    }
}