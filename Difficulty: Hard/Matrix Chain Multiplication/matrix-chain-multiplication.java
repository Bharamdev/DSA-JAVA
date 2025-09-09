class Solution {
    static int[][] dp = new int[101][101];
    static int matrixMultiplication(int arr[]) {
        // code here
       for(int[] curr: dp)  Arrays.fill(curr, -1);
        int n=arr.length;
        return MCM(arr, 0, n-1);
    }
    static int MCM(int[] arr, int start, int end){
        if(start+1 == end) return 0;
        if(dp[start][end] != -1) return dp[start][end];
        int ans=Integer.MAX_VALUE;
        for(int k=start+1; k<end; k++){
            int min = MCM(arr,start, k) + MCM(arr, k, end) + (arr[start]*arr[k]*arr[end]);
            ans = Math.min(ans, min); 
        }
        return dp[start][end] = ans;
    }
}