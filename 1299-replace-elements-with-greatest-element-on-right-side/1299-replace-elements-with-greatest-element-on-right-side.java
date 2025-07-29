class Solution {
    public int[] replaceElements(int[] arr) {
        int max=-1;
        int n = arr.length;
        int[] res = new int[n];
        for(int i=n-1;i>=0;i--){
            res[i]=max;
            max=Math.max(max,arr[i]);
        }
        return res;
    }
}