
class Solution {
    int countPartitions(int[] arr, int d) {
        // code here
        int total=0;
        for(int a: arr) total+=a;
        if((total-d)<0 || (total-d)%2!=0) return 0;
        int sum  = (total-d)/2;
        return countSum(arr, sum);
    }
    int countSum(int[] arr, int sum){
        int n = arr.length;
        int[][] dp = new int[n+1][sum+1];
        for(int i=0;i<=n;i++) dp[i][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(j-arr[i-1]>=0){
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
