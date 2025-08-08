// User function Template for Java

class Solution {

    public int minDifference(int nums[]) {
        // Your code goes here
        int sum=0;
        for(int num: nums) sum+=num;
        List<Integer> arr = subset(nums,sum/2);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.size();i++){
            min = Math.min(min, sum- (2*arr.get(i)));
        }
        return min;
    }
    public List<Integer> subset(int[] nums, int sum){
        int n= nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int j=0;j<=sum;j++){
            dp[0][j]=false;
        }
        for(int i=0;i<=n;i++){
            dp[i][0] = true;
        }
        for(int i=1;i<=n;i++){
            int val = nums[i-1];
            for(int j=1;j<=sum;j++){
                if(j-val>=0){
                    dp[i][j] = dp[i-1][j-val] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<=sum;i++){
            if(dp[n][i]) arr.add(i);
        }
        return arr;
    }
}
