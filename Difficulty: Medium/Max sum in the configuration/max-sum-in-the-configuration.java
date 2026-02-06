class Solution {
    int maxSum(int[] arr) {
        // code here
        int sum=0, currVal=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            currVal += (i*arr[i]);
        }
        int maxVal = currVal;
        for(int i=1;i<n;i++){
            currVal += sum - n*(arr[n-i]);
            maxVal = Math.max(maxVal, currVal);
        }
        return maxVal;
    }
}