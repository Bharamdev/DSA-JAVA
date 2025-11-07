// User function Template for Java
class disjoint{
    int[] parent;
    int[] rank;
    disjoint(int n){
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=0;i<=n;i++){
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
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        disjoint ds = new disjoint(V);
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(i==j) continue;
                if(adj.get(i).get(j)==1) ds.unionRank(i+1,j+1);
            }
        }
        int cnt=0;
        for(int i=1;i<=V;i++){
            if(i==ds.findParent(i)) cnt++;
        }
        return cnt;
    }
}