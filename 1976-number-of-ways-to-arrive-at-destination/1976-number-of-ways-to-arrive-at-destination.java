class Solution {
    class pair{
        int time;
        int node;
        pair(int time, int node){
            this.time = time;
            this.node=node;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] arr: roads){
            adj.get(arr[0]).add(new pair(arr[2],arr[1]));
            adj.get(arr[1]).add(new pair(arr[2],arr[0]));
        }
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        int[] ways = new int[n];
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> a.time-b.time);
        pq.offer(new pair(0,0));
        dist[0]=0;
        ways[0]=1;
        int mod = 1000000007;
        while(!pq.isEmpty()){
            pair p = pq.poll();
            int node = p.node;
            int wt = p.time;
            for(pair it: adj.get(node)){
                int adjNode = it.node;
                int w = it.time;
                if(wt+w < dist[adjNode]){
                    dist[adjNode]=wt+w;
                    ways[adjNode]=ways[node];
                    pq.offer(new pair(wt+w,adjNode));
                } 
                else if(wt+w==dist[adjNode]){
                    ways[adjNode] = (ways[node]+ways[adjNode])%mod;  
                }
            }
        }
        return ways[n-1];
    }
}