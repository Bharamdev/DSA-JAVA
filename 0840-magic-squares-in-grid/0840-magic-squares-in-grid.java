class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int cnt=0;
        for(int r=0; r<n-2;r++){
            for(int c=0;c<m-2;c++){
                if(isMagic(r,c,grid)) cnt++;
            }
        }
        return cnt;
    }
    boolean isMagic(int r, int c, int[][] grid){
        if(grid[r+1][c+1] != 5) return false;
        boolean[] vis = new boolean[10];
        int sum = grid[r][c] + grid[r][c+1] + grid[r][c+2];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int val = grid[r+i][c+j];
                if(val<1 || val>9 || vis[val]) return false;
                vis[val]=true;
            }
        }

        for(int i=0; i<3; i++){
            if(grid[r+i][c]+grid[r+i][c+1]+grid[r+i][c+2]!=sum) return false;
            if(grid[r][c+i]+grid[r+1][c+i]+grid[r+2][c+i]!=sum) return false;
        }
        if(grid[r][c]+grid[r+1][c+1]+grid[r+2][c+2]!=sum) return false;
        if(grid[r][c+2]+grid[r+1][c+1]+grid[r+2][c]!=sum) return false;
        return true;
    }
}