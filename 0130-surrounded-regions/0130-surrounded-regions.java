class Solution {
    int[] delrow = {-1,0,1,0};
    int[] delcol = {0,1,0,-1};
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        // First row
        for(int j=0;j<m;j++){
            if(!vis[0][j] && board[0][j]=='O') dfs(0,j,vis,board);
        }
        // Last row
        for(int j=0;j<m;j++){
            if(!vis[n-1][j] && board[n-1][j]=='O') dfs(n-1,j,vis,board);
        }
        // First col
        for(int i=0;i<n;i++){
            if(!vis[i][0] && board[i][0]=='O') dfs(i,0,vis,board);
        }
        // Last col
        for(int i=0;i<n;i++){
            if(!vis[i][m-1] && board[i][m-1]=='O') dfs(i,m-1,vis,board);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && !vis[i][j]) board[i][j] = 'X';
            }
        }
    }
    void dfs(int i, int j, boolean[][] vis, char[][] board){
        vis[i][j] = true;
        for(int k=0;k<4;k++){
            int nr = i+delrow[k];
            int nc = j+delcol[k];
            if(nr>=0 && nc>=0 && nr<board.length && nc<board[0].length
              && !vis[nr][nc] && board[nr][nc]=='O'){
                dfs(nr,nc,vis,board);
            }
        }
    }
}