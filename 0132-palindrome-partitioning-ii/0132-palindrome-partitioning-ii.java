class Solution {
    static int[][] dp = new int[2001][2001];
    public int minCut(String s) {
        for(int[] arr: dp) Arrays.fill(arr, -1);
        int n = s.length();
        return PP(s, 0, n);
    }
    int PP(String s, int start, int end){
        if(isPalindrome(s, start, end-1)) return 0;
        if(dp[start][end] != -1) return dp[start][end];
        int ans = Integer.MAX_VALUE;
        for(int k=start+1; k<end; k++){
            if(isPalindrome(s, start, k-1)){
                int min = 1 + PP( s, k , end );
                ans = Math.min(ans, min);
            }
        } 
        return dp[start][end] = ans;
    }
    boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}