class Solution {
    class pair{
        int dis;
        int r;
        int c;
        pair(int dis, int r, int c){
            this.dis = dis;
            this.r = r;
            this.c = c;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int[][] dist = new int[n][m];
        for(int[] arr: dist) Arrays.fill(arr,Integer.MAX_VALUE);
        dist[0][0]=0;
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> a.dis-b.dis);
        pq.offer(new pair(0,0,0));
        while(!pq.isEmpty()){
            pair p = pq.poll();
            int diff = p.dis;
            int r = p.r;
            int c = p.c;
            if(r==n-1 && c==m-1) return diff;
            for(int[] d: dir){
                int nr = r+d[0];
                int nc = c+d[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m){
                    int maxEffort=Math.max(diff, Math.abs(heights[nr][nc] - heights[r][c]));
                if(maxEffort<dist[nr][nc]){
                    dist[nr][nc]=maxEffort;
                    pq.offer(new pair(maxEffort, nr, nc));
                }
                }
            }
        }
        return 0;
    }
}