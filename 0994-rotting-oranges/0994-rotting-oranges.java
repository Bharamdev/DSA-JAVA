class Solution {
    int[] delrow = {-1,0,+1,0};
    int[] delcol = {0,+1,0,-1};
    int n;
    int m;
    int cnt=-1;
    class pair{
        int row;
        int col;
        pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int orangesRotting(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]==2){
                    vis[i][j] = true;
                    q.offer(new pair(i,j));
                }
            }
        }
        fn(q,vis,grid);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]==1) return -1;
            }
        }
        return cnt==-1 ? 0 : cnt;
    }
    void fn(Queue<pair> q, boolean[][]vis, int[][] grid){
        while(!q.isEmpty()){
            int size = q.size();
            cnt++;
            for(int i=0;i<size;i++){
                int r = q.peek().row;
                int c = q.poll().col;
                for(int j=0;j<4;j++){
                    int nr = r+delrow[j];
                    int nc = c+delcol[j];
                    if(nr>=0 && nr<n && nc>=0 && nc<m &&
                       !vis[nr][nc] && grid[nr][nc]==1){
                         vis[nr][nc]=true;
                         q.offer(new pair(nr,nc));
                       }
                }
            }
        }
    }
}