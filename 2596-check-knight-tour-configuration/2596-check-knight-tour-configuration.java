class Solution {
    public boolean checkValidGrid(int[][] grid) {
        int[][] dir = {{2,1}, {2,-1}, {-2,1}, {-2,-1},
                       {1,2}, {-1,2}, {1,-2}, {-1,-2}};
        int n = grid.length;
        if(grid[0][0]!=0) return false;
        int[][] pos = new int[n*n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int val = grid[i][j];
                pos[val][0]=i;
                pos[val][1]=j;
            }
        }
        for(int k=0; k<n*n-1; k++){
            int r=pos[k][0], c=pos[k][1];
            int rr=pos[k+1][0], cc=pos[k+1][1];
            boolean ok = false;
            for(int[] d: dir){
                int nr=r+d[0], nc=c+d[1];
                if(nr==rr && nc==cc){
                    ok=true;
                    break;
                }
            }
            if(!ok) return false;
        }
        return true;
    }
}