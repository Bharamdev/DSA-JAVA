class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!bfs(i, color, graph)) return false; 
            }
        }
        return true;
    }
    boolean bfs(int i, int[] color, int[][] graph){
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        color[i]=1;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int adj: graph[node]){
                if(color[adj]==-1){
                    q.offer(adj);
                    color[adj]=1-color[node];
                }
                else if(color[adj]==color[node]) return false;
            }
        }
        return true;
    }
}