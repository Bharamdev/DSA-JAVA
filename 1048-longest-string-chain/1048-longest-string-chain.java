class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> a.length()-b.length());
        int n = words.length;
        int[] dp = new int[n];
        int maxi=0;
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int prev=0;prev<i;prev++){
                if(isValid(words[i],words[prev]) && dp[prev]+1 > dp[i]){
                    dp[i]=1+dp[prev];
                }
            }
            if(dp[i]>maxi) maxi=dp[i];
        }
        return maxi;
    }
    boolean isValid(String s1, String s2){
        int n1 = s1.length(), n2=s2.length();
        if(n1 != n2+1) return false;
        int i=0,j=0;
        while(i<n1 && j<n2){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }
            else i++;
        }
        return j==n2;
    }
}