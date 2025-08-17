class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n=arr.length;
        int left=0;
        while(left+1<n && arr[left]<=arr[left+1]) left++;
        if(left==n-1) return 0;
        int right=n-1;
        while(right>0 && arr[right-1]<=arr[right]) right--;
        int ans = Math.min(n-1-left, right);
        int i=0,j=right;
        while(i<=left && j<n){
            if(arr[i]<=arr[j]){
                i++;
                ans=Math.min(ans,j-i);
            }
            else{
                j++;
            }
        }
        return ans;
    }
}