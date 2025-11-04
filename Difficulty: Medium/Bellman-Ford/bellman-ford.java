// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] dist = new int[V];
        int inf = 100000000;
        Arrays.fill(dist,inf);
        dist[src]=0;
        for(int i=0;i<V;i++){
            for(int[] it: edges){
                int u = it[0];
                int v = it[1];
                int wt = it[2];
                if(dist[u]!=inf && dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                }
            }
        }
        for(int[] it: edges){
                int u = it[0];
                int v = it[1];
                int wt = it[2];
                if(dist[u]!=inf && dist[u]+wt<dist[v]){
                    int[] temp = {-1};
                    return temp;
                }
        }
        return dist;
    }
}
