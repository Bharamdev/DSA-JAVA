class Solution {
    public int countPaths(int V, int[][] edges) {
        // code here
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] e: edges){
            int u=e[0];
            int v=e[1];
            int wt = e[2];
            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(
                                 (a,b) -> a[1]-b[1]);
        int[] dist = new int[V];
        int[] ways = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        ways[0]=1;
        dist[0]=0;
        q.offer(new int[]{0,0});
        while(!q.isEmpty()){
            int node = q.peek()[0];
            int wt = q.poll()[1];
            for(int[] it: adj.get(node)){
                int adjnode = it[0];
                int w = it[1];
                if(wt+w < dist[adjnode]){
                    q.offer(new int[]{adjnode, wt+w});
                    dist[adjnode] = wt+w;
                    ways[adjnode] = ways[node];
                }
                else if(dist[adjnode]==wt+w){
                    ways[adjnode]+=ways[node];
                }
            }
        }
        return ways[V-1];
    }
}
