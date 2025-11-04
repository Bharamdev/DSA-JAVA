class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] arr: edges){
            adj.get(arr[0]).add(new int[]{arr[1],arr[2]});
            adj.get(arr[1]).add(new int[]{arr[0],arr[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->
                                      a[0]-b[0]);
        boolean[] vis = new boolean[V];
        int sum=0;
        pq.offer(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int node = arr[1];
            int wt = arr[0];
            if(vis[node]) continue;   
            vis[node]=true;
            sum+=wt;
            for(int[] it: adj.get(node)){
                int curr = it[0];
                int edw = it[1];
                if(!vis[curr]){
                    pq.offer(new int[]{edw,curr});
                }
            }
        }
        return sum;
    }
}
