class Solution {
    int maxProduct(int[] arr) {
        // code here
        int n = arr.length;
        int max=arr[0], min=arr[0];
        int ans=arr[0];
        for(int i=1;i<n;i++){
            int x=arr[i];
            int temp = Math.max(x, Math.max(max*x, min*x));
            min = Math.min(x, Math.min(max*x, min*x));
            max = temp;
            ans = Math.max(ans, max);
        }
        return ans;
    }
}