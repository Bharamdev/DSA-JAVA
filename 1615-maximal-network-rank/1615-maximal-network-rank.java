class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] indegree = new int[n];
        boolean[][] connected = new boolean[n][n];
        for(int[] r: roads){
            indegree[r[0]]++;
            indegree[r[1]]++;
            connected[r[0]][r[1]]=true;
            connected[r[1]][r[0]]=true;
        }
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int rank = indegree[i]+indegree[j];
                if(connected[i][j]) rank--;
                max = Math.max(max,rank);
            }
        }
        return max;
    }
}