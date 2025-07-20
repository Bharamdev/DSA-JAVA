class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n= arr.length;
        int res=0;
        for(int i=0;i<n;i++){
            int left = i+1;
            int right = n-i;
            int totalsub = left*right;
            int oddsub = (totalsub+1)/2;
            res+=oddsub*arr[i];
        }
        return res;
    }
}