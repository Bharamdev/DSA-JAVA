class Solution {
    public int kBitFlips(int[] arr, int k) {
        // code here
        int cnt=0;
        int n = arr.length;
        int[] flips = new int[n];
        for(int i=0;i<n;i++){
            if(i>0) flips[i]+=flips[i-1];
            if(flips[i]%2==0 && arr[i]==1) continue;
            if(flips[i]%2==1 && arr[i]==0) continue;
            if(i+k>n) return -1;
            cnt++;
            flips[i]++;
            if(i+k<n) flips[i+k]--;
        }
        return cnt;
    }
}
