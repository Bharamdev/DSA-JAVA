class Solution {
    public int maxOnes(int arr[], int k) {
        // code here
        int n=arr.length;
        int j=0;
        int one=0;
        int len=0;
        for(int i=0;i<n;i++){
            if(arr[i]==1) one++;
            while((i-j+1) > one+k){
                if(arr[j]==1) one--;
                j++;
            }
            len = Math.max(len,i-j+1);
        }
        return len;
    }
}