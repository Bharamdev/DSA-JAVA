class Solution {
    boolean[] vis;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        vis = new boolean[n];
        dfs(0,rooms);
        for(int i=0;i<n;i++){
            if(!vis[i]) return false;
        }
        return true;
    }
    void dfs(int room, List<List<Integer>> adj){
        vis[room] = true;
        for(int it: adj.get(room)){
            if(!vis[it]){
                dfs(it,adj);
            }
        }
    }
}