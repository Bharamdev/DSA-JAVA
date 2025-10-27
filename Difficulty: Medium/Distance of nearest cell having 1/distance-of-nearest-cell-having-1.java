class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] ans = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    vis[i][j]=true;
                    q.offer(new int[]{i,j,0});
                    ans[i][j]=0;
                }
            }
        }
        int[][] arr = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r=curr[0], c=curr[1], dist=curr[2];
            for(int[] a: arr){
                int nr = r+a[0];
                int nc = c+a[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m && !vis[nr][nc]){
                    vis[nr][nc]=true;
                    ans[nr][nc]=dist+1;
                    q.offer(new int[]{nr,nc,dist+1});
                }
            }
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add(new ArrayList<>());
            for(int j=0;j<m;j++) res.get(i).add(ans[i][j]);
        }
        return res;
    }
}