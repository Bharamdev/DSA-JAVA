class Solution {
    public int maxOnes(int arr[], int k) {
        // code here
        int len = 0;
        int n=arr.length;
        int l=0;
        int zero=0;
        for(int r=0;r<n;r++){
            if(arr[r]==0) zero++;
            while(l<n && zero>k){
                if(arr[l]==0) zero--;
                l++;
            }
            len = Math.max(len, r-l+1);
        }
        return len;
    }
}