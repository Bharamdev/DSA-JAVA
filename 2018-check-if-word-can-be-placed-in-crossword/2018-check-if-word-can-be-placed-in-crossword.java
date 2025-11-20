class Solution {
    int n;
    int m;
    public boolean placeWordInCrossword(char[][] board, String word) {
        n = board.length;
        m=board[0].length;
        String rev = new StringBuilder(word).reverse().toString();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==' ' || board[i][j]==word.charAt(0) || 
                   board[i][j] == rev.charAt(0)){
                    if(placeHorizontally(board, word, i, j)) return true;
                    if(placeHorizontally(board, rev, i, j)) return true;

                    if(placeVertically(board, word, i, j)) return true;
                    if(placeVertically(board, rev, i, j)) return true;
                }
            }
        }
        return false;
    }
    boolean placeHorizontally(char[][] board, String word, int i, int j){
        if(j-1>=0 && board[i][j-1]!='#') return false;
        if(j+word.length()<m && board[i][j+word.length()]!='#') return false;
        for(int jj=0;jj<word.length();jj++){
            if(j+jj>=m) return false;
            if(board[i][j+jj]!=' ' && board[i][j+jj]!=word.charAt(jj)) return false;;
        }
        return true;
    }
    boolean placeVertically(char[][] board, String word, int i, int j){
        if(i-1>=0 && board[i-1][j]!='#') return false;
        if(i+word.length()<n && board[i+word.length()][j]!='#') return false;
        for(int ii=0;ii<word.length();ii++){
            if(i+ii>=n) return false;
            if(board[i+ii][j]!=' ' && board[i+ii][j]!=word.charAt(ii)) return false;;
        }
        return true;
    }
}
