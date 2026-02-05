class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int n=arr.length;
        int l=0;
        long sum=0;
        long ans=0;
        for(int r=0;r<n;r++){
            sum+=arr[r];
            ans = Math.max(ans,sum);
            if(r-l+1==k){
                sum-=arr[l];
                l++;
            }
        }
        return (int)ans;
    }
}