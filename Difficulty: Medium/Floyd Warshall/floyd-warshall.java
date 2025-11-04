// User function template for JAVA

class Solution {
    public void floydWarshall(int[][] dist) {
        // Code here
        int n = dist.length;
        // int[][] matrix = new int[n][n];
        int inf=100000000;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]!=inf && dist[k][j]!=inf){
                        dist[i][j] = Math.min(dist[i][j], 
                                        dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }
}