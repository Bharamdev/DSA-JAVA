// User function Template for Java
class Solution {
    static int[][][] dp;
    static int countWays(String s) {
        // code here
        int n=s.length();
        dp = new int[n][n][2];
        for(int[][] a: dp){
            for(int[] b: a) Arrays.fill(b, -1);
        }
        return fn(0,n-1,1,s);
    }
    static int fn(int i, int j, int isTrue, String s){
        if(i>j) return 0;
        if(i==j){
            if(isTrue==1) return s.charAt(i)=='T' ? 1 : 0;
            else return s.charAt(i)=='F' ? 1 : 0;
        }
        if(dp[i][j][isTrue] != -1) return dp[i][j][isTrue];
        int ways=0;
        for(int idx=i+1; idx<=j-1; idx++){
            int lt = fn(i, idx-1, 1, s);
            int lf = fn(i, idx-1, 0, s);
            int rt = fn(idx+1, j, 1, s);
            int rf = fn(idx+1, j, 0, s);
            
            if(s.charAt(idx)=='&'){
                if(isTrue==1) ways+=(lt*rt);
                else ways+= (lt*rf)+(lf*rt)+(lf*rf);
            }
            else if(s.charAt(idx)=='|'){
                if(isTrue==1) ways+=(lt*rt)+(lt*rf)+(lf*rt);
                else ways+=(lf*rf);
            }
            else{
                if(isTrue==1) ways+=(lt*rf)+(lf*rt);
                else ways+=(lf*rf)+(lt*rt);
            }
        }
        return dp[i][j][isTrue] = ways;
    }
}