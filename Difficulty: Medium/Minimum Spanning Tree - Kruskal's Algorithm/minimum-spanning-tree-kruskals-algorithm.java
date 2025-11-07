// User function Template for Java
class disjoint{
    int[] parent;
    int[] rank;
    disjoint(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }
    int findParent(int node){
        if(parent[node]==node) return node;
        return parent[node] = findParent(parent[node]);
    }
    void unionRank(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);
        if(pu==pv) return;
        if(rank[pu]<rank[pv]) parent[pu] = pv;
        else if (rank[pv]<rank[pu]) parent[pv] = pu;
        else{
            parent[pv] = pu;
            rank[pu]++;
        }
    }
}
class Solution {
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        Arrays.sort(edges, (a,b) -> a[2]-b[2]);
        disjoint ds = new  disjoint(V);
        int wt=0;
        for(int[] e: edges){
            int u = e[0];
            int v = e[1];
            if(ds.findParent(u) != ds.findParent(v)){
                ds.unionRank(u,v);
                wt+=e[2];
            }
        }
        return wt;
    }
}
