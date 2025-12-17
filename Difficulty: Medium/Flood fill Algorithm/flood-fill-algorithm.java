class Solution {
    boolean[][] vis;
    int[][] dir = {{-1,0},{0,-1},{0,1},{1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // code here
        vis = new boolean[image.length][image[0].length];
        int old = image[sr][sc];
        image[sr][sc]=newColor;
        dfs(image, sr,sc,newColor, old);
        return image;
    }
    void dfs(int[][] image, int r, int c, int newColor, int old){
        vis[r][c]=true;
        for(int[] d: dir){
            int nr = r+d[0];
            int nc = c+d[1];
            if(nr>=0 && nc>=0 && nr<image.length && 
            nc<image[0].length && !vis[nr][nc] && image[nr][nc]==old){
                image[nr][nc]=newColor;
                dfs(image, nr, nc, newColor, old);
            }
        }
    }
}