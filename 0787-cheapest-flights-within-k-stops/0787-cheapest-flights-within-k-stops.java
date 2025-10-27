class Solution {
    class pair{
        int stops;
        int node;
        int cost;
        pair(int cost, int node, int stops){
            this.cost = cost;
            this.node = node;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] f: flights){
            adj.get(f[0]).add(new int[]{f[1],f[2]});
        } 
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<pair> q = new LinkedList<>();
        dist[src]=0;
        q.offer(new pair(0, src, 0));
        while(!q.isEmpty()){
            pair p = q.poll();
            int stop = p.stops, cost = p.cost, node=p.node;
            if(stop>k) continue;
            for(int[] it: adj.get(node)){
                int price = it[1];
                int curr = it[0];
                int newCost = cost+price;
                if(newCost<dist[curr] && stop<=k){
                    dist[curr]=newCost;
                    q.offer(new pair(newCost, curr, stop+1));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}