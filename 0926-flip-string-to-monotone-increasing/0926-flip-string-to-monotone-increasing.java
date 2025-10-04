class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] dp0 = new int[n];
        int[] dp1 = new int[n];
        dp0[0] = s.charAt(0)=='0' ? 0 : 1;
        dp1[0] = s.charAt(0)=='1' ? 0 : 1;
        for(int i=1;i<n;i++){
            char ch = s.charAt(i);
            if(ch=='0'){
                dp0[i] = dp0[i-1]; // not flip
                dp1[i] = Math.min(dp0[i-1], 1+dp1[i-1]);  // 0 -> 1
            }
            else{ // ch=='1'
                dp0[i] = 1+dp0[i-1];      // 1 -> 0
                dp1[i] = Math.min(dp0[i-1], dp1[i-1]);  // keep 1
            }
        }
        return Math.min(dp0[n-1], dp1[n-1]);
    }
}