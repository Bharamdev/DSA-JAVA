// User function Template for Java
class disjoint{
    int parent[];
    int rank[];
    disjoint(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
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
    int[][] dir = {{-1,0},{0,-1},{0,1},{1,0}};
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        // Your code here
        disjoint ds = new disjoint(rows*cols);
        List<Integer> ans = new ArrayList<>();
        int cnt=0;
        int[][] grid = new int[rows][cols];
        for(int[] op: operators){
            int r = op[0];
            int c = op[1];
            if(grid[r][c]==1){
                ans.add(cnt);
                continue;
            }
            grid[r][c]=1;
            cnt++;
            for(int[] d: dir){
                int nr = r+d[0];
                int nc = c+d[1];
                if(isValid(rows, cols, nr, nc)){
                    if(grid[nr][nc]==1){
                        int node = r*cols + c;
                        int adjnode = nr*cols + nc;
                        if(ds.findparent(node) != ds.findparent(adjnode)){
                            cnt--;
                            ds.unionRank(node,adjnode);
                        }
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }
    boolean isValid(int n, int m, int r, int c){
        if(r>=0 && c>=0 && r<n && c<m ) return true;
        return false;
    }
}