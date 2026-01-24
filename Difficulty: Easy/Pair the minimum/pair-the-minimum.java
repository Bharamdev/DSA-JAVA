// User function Template for Java

class Solution {

    // Function for finding maximum and value pair
    public static int Pair_minimum(int arr[]) {
        // Complete the function
        Arrays.sort(arr);
        int n=arr.length;
        int i=0,j=n-1;
        int ans=0;
        while(i<j){
            int sum=arr[i]+arr[j];
            ans = Math.max(sum,ans);
            i++;
            j--;
        }
        return ans;
    }
}
