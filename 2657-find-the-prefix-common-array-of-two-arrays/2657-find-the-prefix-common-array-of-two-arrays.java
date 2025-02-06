class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] arr = new int[51];
        int[] ans = new int[A.length];
        int cnt=0;
        for(int i=0; i<A.length; i++){
            arr[A[i]]++;
             arr[B[i]]++;

            if(A[i]!=B[i]){
                if(arr[A[i]]>1) cnt++;
                if(arr[B[i]]>1) cnt++;
            } else{
                cnt++;
            }

            ans[i] = cnt;
        }
               
        return ans;
    }
}