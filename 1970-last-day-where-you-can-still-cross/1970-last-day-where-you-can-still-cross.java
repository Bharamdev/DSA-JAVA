class Solution {
    int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
    int row,col;
    public int latestDayToCross(int row, int col, int[][] cells) {
        this.row=row;
        this.col=col;
        int l=0,r=cells.length-1;
        int lastDay=0;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(isPath(cells, mid)){
                l=mid+1;
                lastDay=mid+1;
            }
            else r=mid-1;
        }
        return lastDay;
    }
    boolean isPath(int[][] cells, int mid){
        boolean[][] grid = new boolean[row][col];
        for(int i=0;i<=mid;i++){
            int x = cells[i][0]-1;
            int y = cells[i][1]-1;
            grid[x][y]=true;
        }
        for(int i=0;i<col;i++){
            if(!grid[0][i] && dfs(0,i,grid)) return true;
        }
        return false;
    }
    boolean dfs(int r, int c, boolean[][] grid){
        if(r<0 || c<0 || r>=row ||c>=col || grid[r][c]) return false;
        if(r==row-1) return true;
        grid[r][c]=true;
        for(int[] d: dir){
            int nr = r+d[0];
            int nc = c+d[1];
            if(dfs(nr,nc,grid)) return true;
        }
        return false;
    }
}