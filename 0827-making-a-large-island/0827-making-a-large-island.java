class disjoint{
    int[] parent;
    int[] size;
    disjoint(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    int findparent(int node){
        if(parent[node]==node) return node;
        return parent[node] = findparent(parent[node]);
    }
    void unionSize(int u, int v){
        int pu = findparent(u);
        int pv = findparent(v);
        if(pu==pv) return;
        if(size[pu]>size[pv]) {
            parent[pv]=pu;
            size[pu]+=size[pv];
        }
        else{
            parent[pu]=pv;
            size[pv]+=size[pu];
        }
    }
}
class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;   
        disjoint ds = new disjoint(n*n);
        int[][] dir = {{-1,0}, {0,-1}, {1,0}, {0,1}};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) continue;
                for(int[] d: dir){
                    int r = i+d[0];
                    int c = j+d[1];
                    if(isValid(n,r,c)){
                        if(grid[r][c]==1){
                            int node = i*n + j;
                            int adjnode = r*n + c;
                            ds.unionSize(node, adjnode);
                        }
                    }
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) continue;
                HashSet<Integer> set = new HashSet<>();
                for(int[] d: dir){
                    int r = i+d[0];
                    int c = j+d[1];
                    if(isValid(n,r,c)){
                        if(grid[r][c]==1){
                            int adjnode = r*n + c;
                            set.add(ds.findparent(adjnode));
                        }
                    }
                }
                int max=1;
                for(int p: set){
                    max += ds.size[p];
                }
                if(max>ans) ans=max;
            }
        }
        for(int i=0;i<n*n;i++){
            ans = Math.max(ans, ds.size[ds.findparent(i)]);
        }
        return ans;
    }
    boolean isValid(int n, int r, int c){
        if(r>=0 && c>=0 && r<n && c<n) return true;
        return false;
    }
}