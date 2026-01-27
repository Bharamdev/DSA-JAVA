class Solution {
    int n,m;
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public boolean isWordExist(char[][] mat, String word) {
        // Code here
        n = mat.length;
        m = mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==word.charAt(0)){
                    if(solve(0,i,j,mat,word)) return true;
                }
            }
        }
        return false;
    }
    boolean solve(int idx, int r, int c, char[][] mat, String word){
        if(idx==word.length()-1) return true;
        char temp = mat[r][c];
        mat[r][c]='#';
        for(int[] d: dir){
            int nr = r+d[0];
            int nc = c+d[1];
            char ch = word.charAt(idx+1);
            if(nr>=0 && nc>=0 && nr<n && nc<m && mat[nr][nc]==ch){
                if(solve(idx+1, nr, nc, mat, word)) return true;
            }
        }
        mat[r][c]=temp;
        return false;
    }
}