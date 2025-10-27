class Solution {
    class pair{
        int dist;
        int node;
        pair(int dist, int node){
            this.dist = dist;
            this.node = node;
        }
    }
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        List<List<pair>> adj = new ArrayList<>();
        for(int i=0;i<= n;i++) adj.add(new ArrayList<>());
        for(int[] arr: edges){
            adj.get(arr[0]).add(new pair(arr[2],arr[1]));
            adj.get(arr[1]).add(new pair(arr[2],arr[0]));
        }
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> 
                                        a.dist-b.dist);
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];
        for(int i=1;i<=n;i++){
            dist[i]=Integer.MAX_VALUE;
            parent[i]=i;
        }
        dist[1]=0;
        pq.offer(new pair(0,1));
        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int dis = pq.poll().dist;
            for(pair p: adj.get(node)){
                int it = p.node;
                int d = p.dist;
                if(dis+d < dist[it]){
                    dist[it] = dis+d;
                    pq.offer(new pair(dis+d, it));
                    parent[it]=node;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(dist[n]==Integer.MAX_VALUE){
            ans.add(-1);
            return ans;
        }
        int curr=n;
        while(parent[curr]!=curr){
            ans.add(curr);
            curr = parent[curr];
        }
        ans.add(1);
        Collections.reverse(ans);
        ans.add(0,dist[n]);
        return ans;
    }
}