class Solution {
    int[][] dp;
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int c = cuts.length;
        int[] arr = new int[c+2];
        arr[0]=0;
        arr[c+1]=n;
        dp = new int[c+1][c+1];
        for(int[] a: dp) Arrays.fill(a,-1);
        for(int i=0;i<c;i++) arr[i+1]=cuts[i];
        return fn(1,c,arr);
    }
    int fn(int i, int j, int[] arr){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int mini=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int cost = arr[j+1]-arr[i-1] + fn(i,k-1,arr) + fn(k+1,j,arr);
            mini = Math.min(mini,   cost);
        } 
        return dp[i][j] = mini;
    }
}