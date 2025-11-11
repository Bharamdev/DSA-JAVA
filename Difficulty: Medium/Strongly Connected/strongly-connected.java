class Solution {
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        boolean[] vis = new boolean[n];
        Stack<Integer> st = new Stack<>();
        // Sort the array
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,vis,adj,st);
            }
        }
        Arrays.fill(vis,false);
        // Transpose if adj 
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i=0;i<n;i++) adjT.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            for(int it: adj.get(i)){
                adjT.get(it).add(i);
            }
        }
        int cnt=0;
        while(!st.isEmpty()){
            int node = st.pop();
            if(!vis[node]){
                dfs2(node,vis,adjT);
                cnt++;
            }
        }
        return cnt;
    }
    void dfs(int node,boolean[] vis,ArrayList<ArrayList<Integer>> adj,
              Stack<Integer> st){
        vis[node]=true;
        for(int it: adj.get(node)){
            if(!vis[it]){
                dfs(it,vis,adj,st);
            }
        }
        st.push(node);
    }
    void dfs2(int node,boolean[] vis,ArrayList<ArrayList<Integer>> adjT){
        vis[node]=true;
        for(int it: adjT.get(node)){
            if(!vis[it]){
                dfs2(it,vis,adjT);
            }
        }
    }
}