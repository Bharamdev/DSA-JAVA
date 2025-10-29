class Solution {
    public void solveSudoku(char[][] board) {
        solve(board,0,0);
    }
    boolean solve(char[][] board, int i, int j){
        if(i==board.length) return true;
        int ni=0,nj=0;
        if(j==board.length-1){
            ni=i+1;
            nj=0;
        }
        else{
            ni=i;
            nj=j+1;
        }
        if(board[i][j]!='.'){
            if(solve(board,ni,nj)) return true;
        }
        else{
            for(int num=1;num<=9;num++){
                char ch = (char)(num+'0');
                if(isValid(board, i, j, ch)){
                    board[i][j] = ch;
                    if(solve(board,ni,nj)) return true;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }
    boolean isValid(char[][] board, int row, int col, char ch){
        for(int i=0;i<9;i++){
            if(board[row][i]==ch) return false;
            if(board[i][col]==ch) return false;
        }
        int nr = (row/3)*3;
        int nc = (col/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[nr+i][nc+j]==ch) return false;
            }
        }
        return true;
    }
}