class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] arr, int target) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n+1][target+1];
        for(int i=0;i<=n;i++) dp[i][0]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=target;j++){
                if(j-arr[i-1]>=0){
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }
}