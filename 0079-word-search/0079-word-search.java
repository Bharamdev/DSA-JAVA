class Solution {
    int n,m;
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(word.charAt(0)==board[i][j]){
                    if(dfs(0,i,j,board,word)) return true;
                }
            }
        }
        return false;
    }
    boolean dfs(int idx, int r, int c, char[][] board, String word){
        if(word.charAt(idx)!=board[r][c]) return false;
        if(idx==word.length()-1) return true;
        char temp = board[r][c];
        board[r][c]='#';
        for(int[] d: dir){
            int nr=r+d[0];
            int nc=c+d[1];
            if(nr>=0 && nc>=0 && nr<n && nc<m && board[nr][nc]==word.charAt(idx+1)){
                if(dfs(idx+1, nr, nc, board, word)) return true;
            }
        }
        board[r][c]=temp;
        return false;
    }
}