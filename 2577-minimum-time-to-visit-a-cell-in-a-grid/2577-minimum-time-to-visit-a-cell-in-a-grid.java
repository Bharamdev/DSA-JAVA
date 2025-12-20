class Solution {
    public int minimumTime(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
        int[][] dist = new int[n][m];
        for(int[] d: dist) Arrays.fill(d, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        pq.offer(new int[]{0,0,0});
        if(grid[0][1]>1 && grid[1][0]>1) return -1;
        dist[0][0]=0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r=curr[0], c=curr[1];
            int time=curr[2];
            if(r==n-1 && c==m-1) return time;
            if(time > dist[r][c]) continue;
            for(int[] d: dir){
                int nr = r+d[0];
                int nc = c+d[1];
                if(nr<0 || nc<0 || nr>=n || nc>=m ) continue;
                int nextTime = time+1;
                if(nextTime < grid[nr][nc]) {
                    int diff = grid[nr][nc] - nextTime;
                    if(diff%2==1) diff++;
                    nextTime+=diff;
                }
                if(nextTime < dist[nr][nc]){
                    dist[nr][nc] = nextTime;
                    pq.offer(new int[]{nr,nc,nextTime});
                }
            }
        }
        return -1;
    }
}