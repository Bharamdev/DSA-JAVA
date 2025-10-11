class Solution {
    int[] delrow = {-1,0,+1,0};
    int[] delcol = {0,+1,0,-1};
    int n;
    int m;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        n = image.length;
        m = image[0].length;
        int[][] mat = new int[n][m];
        for(int i=0;i<n;i++){
            mat[i] = Arrays.copyOf(image[i], m);
        }
        int old = image[sr][sc];
        dfs(sr,sc,image,color,old,mat);
        return mat;
    }
    void dfs(int r, int c, int[][] image, int color, int old, int[][] mat){
        mat[r][c] = color;
        for(int i=0;i<4;i++){
            int nr = r + delrow[i];
            int nc = c + delcol[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && 
               mat[nr][nc]==old){
                if(old!=color) dfs(nr,nc,image,color,old,mat);
               }
        }
    }
}