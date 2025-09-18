class Solution {
    public int getMinDiff(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        int diff = arr[n-1]-arr[0];
        int ans=diff;
        int smallest = arr[0]+k;
        int largest = arr[n-1]-k;
        for(int i=0;i<n-1;i++){
            int max = Math.max(largest, arr[i]+k);
            int min = Math.min(smallest, arr[i+1]-k);
            if(min < 0)  continue;
            ans = Math.min(ans, max-min);
        }
        return ans;
    }
}
