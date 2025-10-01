// User function Template for Java

class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        // Code here
        int n = arr.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        int idx=0;
        int maxi=0;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            dp[i]=1;
            hash[i] = i; 
            for(int prev=0;prev<i;prev++){
                if(arr[i]>arr[prev] && 1+dp[prev] > dp[i]){
                    dp[i] = 1+dp[prev];
                    hash[i] = prev;
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
                idx=i;
            }
        }
        res.add(arr[idx]);
        while(idx != hash[idx]){
            idx = hash[idx];
            res.add(arr[idx]);
        }
        Collections.reverse(res);
        return res;
        
    }
}
