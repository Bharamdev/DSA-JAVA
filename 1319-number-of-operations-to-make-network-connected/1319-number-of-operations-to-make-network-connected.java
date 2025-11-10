class disjoint{
    int[] parent;
    int[] rank;
    disjoint(int n){
        parent = new int[n];
        rank = new int[n];
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
    public int makeConnected(int n, int[][] connections) {
        disjoint ds = new disjoint(n);
        int extraCables=0;
        for(int[] con: connections){
            int u=con[0];
            int v=con[1];
            if(ds.findparent(u)==ds.findparent(v)) extraCables++;
            else{
                ds.unionRank(u,v);
            }
        }   
        int required=0;
        for(int i=0;i<n;i++){
            if(ds.parent[i]==i) required++;
        }     
        required = required-1;
        if(extraCables>=required) return required;
        return -1;
    }
}