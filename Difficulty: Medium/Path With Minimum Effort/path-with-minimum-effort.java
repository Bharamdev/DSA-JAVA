class Solution {
    int[][] dir = {{-1,0}, {0,-1}, {1,0}, {0,1}};
    public int minCostPath(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                                      (a,b) -> a[0]-b[0]);
        int[][] dist = new int[n][m];
        for(int[] d: dist) Arrays.fill(d, Integer.MAX_VALUE);
        pq.offer(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r=curr[1];
            int c=curr[2];
            int w=curr[0];
            if(r==n-1 && c==m-1) return w;
            for(int[] d: dir){
                int nr = r+d[0];
                int nc = c+d[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m){
                    int wt = Math.abs(mat[r][c]-mat[nr][nc]);
                    int maxWt = Math.max(w, wt);
                    if(maxWt<dist[nr][nc]){
                        dist[nr][nc]=maxWt;
                        pq.offer(new int[]{maxWt, nr, nc});
                    }
                }
            }
        }
        return  dist[n-1][m-1];
    }
}
