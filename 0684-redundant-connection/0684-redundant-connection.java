class disjoint{
    int[] parent;
    int[] rank;
    disjoint(int n){
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=0;i<n;i++) parent[i]=i;
    }
    int findparent(int node){
        if(parent[node]==node) return node;
        return parent[node] = findparent(parent[node]);
    }
    void unionRank(int u, int v){
        int pu = findparent(u);
        int pv = findparent(v);
        if(pu==pv) return;
        if(rank[pu]>rank[pv]) parent[pv]=pu;
        else if(rank[pu]<rank[pv]) parent[pu]=pv;
        else{
            parent[pv]=pu;
            rank[pu]++;
        }
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        disjoint ds = new disjoint(n);
        int[] ans = new int[2];
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            if(ds.findparent(u) != ds.findparent(v)){
                ds.unionRank(u,v);
            }
            else{
                ans[0]=u;
                ans[1]=v;
            }
        }
        return ans;
    }
}