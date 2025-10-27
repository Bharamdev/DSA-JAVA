class Solution {
    class pair{
        int row;
        int col;
        int step;
        pair(int row, int col, int step){
            this.row = row;
            this.col = col;
            this.step=step;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        boolean[][] vis = new boolean[n][n];
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(0,0,1));
        vis[0][0]=true;
        while(!q.isEmpty()){
            pair p = q.poll();
            int r = p.row;
            int c = p.col;
            int s = p.step;
            if(r==n-1 && c==n-1) return s;
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int nr = r+i;
                    int nc = c+j;
                    if(nr>=0 && nc>=0 && nr<n && nc<n && !vis[nr][nc] && grid[nr][nc]==0){
                        vis[nr][nc] = true;
                        q.offer(new pair(nr,nc,s+1));
                    }
                }
            }
        }
        return -1;
    }
}