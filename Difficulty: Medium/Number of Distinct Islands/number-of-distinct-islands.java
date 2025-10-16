// User function Template for Java

class Solution {
    int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        Set<List<List<Integer>>> set = new HashSet<>();
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                List<List<Integer>> shape = new LinkedList<>();
                if(!vis[i][j] && grid[i][j]==1){
                    dfs(i,j,vis,grid,shape,i,j);
                    set.add(shape);
                }
            }
        }
        return set.size();
    }
    void dfs(int r, int c, boolean[][] vis, int[][] grid,
            List<List<Integer>> shape, int pr, int pc){
            
            if(r<0 || c<0 || r>=grid.length || c>=grid[0].length ||
               vis[r][c] || grid[r][c]==0) return;
            List<Integer> arr = new ArrayList<>();
            arr.add(r-pr);
            arr.add(c-pc);
            shape.add(arr);
            vis[r][c]=true;
            for(int[] d: dir){
                dfs(r+d[0],c+d[1],vis,grid,shape,pr,pc);
            }
    }
}
