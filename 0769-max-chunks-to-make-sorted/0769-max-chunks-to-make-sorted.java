class Solution {
    public int maxChunksToSorted(int[] arr) {
        int cnt=0,maxi=0;
        for(int i=0;i<arr.length;i++){
            maxi= Math.max(maxi,arr[i]);
            if(maxi==i){
                cnt++;
            }
        }
        return cnt;
    }
}