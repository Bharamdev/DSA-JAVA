class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
        int[][] dist = new int[n][n];
        for(int[] d: dist) Arrays.fill(d, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        if(grid[0][0]==0){
            q.offer(new int[]{0,0,1});      // row,col,dist
            dist[0][0]=1;
        }   
        else{
            q.offer(new int[]{0,0,0});
            dist[0][0]=0;
        }
        int max=-1;
        boolean one=false,zero=false;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r=curr[0], c=curr[1], dis=curr[2];
            for(int[] d: dir){
                int nr = r+d[0], nc = c+d[1];
                int ndis=dis;
                if(nr<0 || nc<0 || nr>=n || nc>=n) continue;
                if(grid[nr][nc]==1) {
                    ndis=0;
                    one=true;
                }
                else{
                    ndis=ndis+1;
                    zero=true;
                }
                if(ndis<dist[nr][nc]) {
                    q.offer(new int[]{nr,nc,ndis});
                    dist[nr][nc] = ndis;
                }
            }
        }  
        for(int[] d: dist){
            for(int a: d) max = Math.max(max,a);
        }
        if(!one || !zero) return -1;
        return max;
    }
}