class Solution {
    public int lastStoneWeightII(int[] stones) {
        int total=0;
        for(int s: stones) total+=s;
        int target = total/2;
        boolean[] dp = new boolean[target+1];
        dp[0]=true;
        for(int st: stones){
            for(int j=target; j>=st; j--){
                dp[j] = dp[j] || dp[j-st];
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=target;i>=0;i--){
            if(dp[i]) return total - 2*(i);
        }
        return 0;
    }
}