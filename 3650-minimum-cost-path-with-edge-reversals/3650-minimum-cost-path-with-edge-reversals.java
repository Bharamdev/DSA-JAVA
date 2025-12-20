class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e: edges){
            adj.get(e[0]).add(new int[]{e[1], e[2]});     // Original
            adj.get(e[1]).add(new int[]{e[0], e[2]*2});   // Reverse using switch
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.offer(new int[]{0,0});
        dist[0]=0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int cost = curr[1];
            if(cost>dist[node]) continue;
            if(node==n-1) return cost;
            for(int[] it: adj.get(node)){
                int newcost = cost + it[1];
                int next = it[0];
                if(newcost < dist[next]){
                    pq.offer(new int[]{next, newcost});
                    dist[next] = newcost;
                }
            }
        }
        return -1;
    }
}