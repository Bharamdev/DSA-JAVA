class Solution {
    int[] delrow = {-1,0,+1,0};
    int[] delcol = {0,1,0,-1};
    int n;
    int m;
    class pair{
        int row;
        int col;
        int steps;
        pair(int row, int col, int steps){
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        n = mat.length;
        m = mat[0].length;
        Queue<pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        int[][] ans = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.offer(new pair(i,j,0));
                    vis[i][j]=true;
                }
            }
        }
        bfs(q,vis,ans,mat);
        return ans;
    }
    void bfs(Queue<pair> q, boolean[][] vis, int[][] ans, int[][] mat){
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int step = q.poll().steps;
            ans[r][c] = step;
            for(int j=0;j<4;j++){
                int nr = r+delrow[j];
                int nc = c+delcol[j];
                if(nr>=0 && nr<n && nc>=0 && nc<m && 
                    !vis[nr][nc]){
                        vis[nr][nc] = true;
                        q.offer(new pair(nr,nc,step+1));
                    }
            }
            
        }
    }
}