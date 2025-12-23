class Solution {
    public void solveSudoku(int[][] mat) {
        // code here
        solve(0, 0, mat);
    }
    boolean solve(int r, int c, int[][] mat){
        if(c==mat.length){
            r=r+1;
            c=0;
        }
        if(r==mat.length) return true;
        if(mat[r][c]!=0) return solve(r,c+1,mat);
        for(int i=1;i<=9;i++){
            if(isValid(r,c,mat,i)){
                mat[r][c] = i;
                if(solve(r,c+1,mat)) return true;
                mat[r][c]=0;
            }
        }
        return false;
    }
    boolean isValid(int r, int c, int[][] mat, int num){
        for(int i=0;i<mat.length;i++){
            if(mat[r][i]==num) return false;
            if(mat[i][c]==num) return false;
        }
        int nr = (r/3) * 3;
        int nc = (c/3) * 3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(mat[nr+i][nc+j]==num) return false;
            }
        }
        return true;
    }
}