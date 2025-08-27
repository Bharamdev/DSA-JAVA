class Solution {
    public int countTriangles(int arr[]) {
        // code here
        Arrays.sort(arr);
        int n=arr.length;
        int cnt=0;
        for(int k=n-1;k>=2;k--){
            int i=0,j=k-1;
            while(i<j){
                if(arr[i]+arr[j]>arr[k]){
                    cnt+=j-i;
                    j--;
                }
                else i++;
            }
        }
        return cnt;
    }
}