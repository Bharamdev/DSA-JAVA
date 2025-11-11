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
    public int removeStones(int[][] stones) {
        int n=0,m=0;
        int total = stones.length;
        for(int[] stone: stones){
            n = Math.max(n, stone[0]);
            m = Math.max(m, stone[1]);
        }
        // You computed n = max(row index) and m = max(col index). These are maximum indices, not counts. If max row index is 4, there are 5 rows (0..4). You must use rows = maxRow + 1
        n=n+1;
        m=m+1;
        disjoint ds = new disjoint(n+m);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int[] stone: stones){
            int nodeR = stone[0];
            int nodeC = stone[1]+n;
            ds.unionRank(nodeR, nodeC);
            map.put(nodeR, 1);
            map.put(nodeC, 1);
        }
        int cnt=0;
        for(Map.Entry<Integer,Integer> it: map.entrySet()){
            if(ds.findparent(it.getKey()) == it.getKey()) cnt++;
        }
        return total-cnt;
    }
}