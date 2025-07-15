class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n=arr.length;
        int[] res = new int[k];
        int r=n-1,l=0,index=0;
        int mid = arr[(n-1)/2];
        while(k-->0){
            int diffr = Math.abs(arr[r]-mid);
            int diffl = Math.abs(arr[l]-mid);
            if(diffr>diffl) res[index++]=arr[r--];
            else if(diffr<diffl) res[index++]=arr[l++];
            else{
                if(arr[r]>=arr[l]) res[index++]=arr[r--];
                else res[index++]=arr[l++];
            }
        }
        return res;
    }
}