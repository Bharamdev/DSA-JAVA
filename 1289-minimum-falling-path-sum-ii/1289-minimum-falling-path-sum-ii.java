class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int min = Integer.MAX_VALUE;
        int[] prev = new int[n];
        for(int i=0;i<n;i++) prev[i] = grid[0][i];
        for(int i=1;i<n;i++){
            int min1=Integer.MAX_VALUE, min2=Integer.MAX_VALUE;
            int idx=-1;
            // First and second smallest in prev row
            for(int j=0;j<n;j++){
                int val = prev[j];
                if(val<min1){
                    min2=min1;
                    min1=val;
                    idx=j;
                }
                else if(val<min2) min2=val;
            }

            int[] curr = new int[n];
            for(int j=0;j<n;j++){
                if(j!=idx){
                    curr[j] = grid[i][j] + min1;
                }
                else curr[j] = grid[i][j] + min2;
            }
            prev=curr;
        }
        for(int j=0;j<n;j++) min = Math.min(min, prev[j]);
        return min;
    }
}