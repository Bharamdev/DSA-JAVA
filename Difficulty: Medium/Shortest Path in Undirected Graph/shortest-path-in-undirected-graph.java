class Solution {
    class pair{
        int node;
        int dist;
        pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        int n = adj.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(src,0));
        while(!q.isEmpty()){
            int node = q.peek().node;
            int weight = q.poll().dist;
            for(int it: adj.get(node)){
                int total = weight+1;
                if(total<dist[it]){
                    dist[it] = total;
                    q.offer(new pair(it,total));
                }
            }
        }
        for(int i=0;i<n;i++){
            if(dist[i]==Integer.MAX_VALUE) dist[i]=-1;
        }
        return dist;
    }
}
