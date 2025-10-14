class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        Queue<Integer> q = new LinkedList<>();
        int n = adj.size();
        boolean[] vis = new boolean[n];
        q.offer(0);
        ArrayList<Integer> arr = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            arr.add(node);
            vis[node] = true;
            for(int i: adj.get(node)){
                if(!vis[i]){
                    vis[i]=true;
                    q.offer(i);
                }
            }
        }
        return arr;
    }
}