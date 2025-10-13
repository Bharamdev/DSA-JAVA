class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int n = adj.size();
        boolean[] vis = new boolean[n];
        ArrayList<Integer> arr = new ArrayList<>();
        fn(0,adj,vis,arr);
        return arr;
    }
    void fn(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, 
            ArrayList<Integer> arr){
        vis[node]=true;
        arr.add(node);
        for(int i: adj.get(node)){
            if(!vis[i]) fn(i,adj,vis,arr);
        }
    }
}