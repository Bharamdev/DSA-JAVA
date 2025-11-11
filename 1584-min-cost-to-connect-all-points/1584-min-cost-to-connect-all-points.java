class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        int sum=0;
        int connected=0;
        boolean[] vis = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.offer(new int[]{0,0});
        while(connected<n){
            int[] top = pq.poll();
            int cost = top[0];
            int node = top[1];
            if(vis[node]) continue;
            vis[node]=true;
            sum+=cost;
            connected++;
            for(int it=0;it<n;it++){
                if(!vis[it]){
                    int dist = Math.abs(points[node][0]-points[it][0]) +
                               Math.abs(points[node][1]-points[it][1]);
                    pq.offer(new int[]{dist,it});
                }
            }
        }
        return sum;
    }
}