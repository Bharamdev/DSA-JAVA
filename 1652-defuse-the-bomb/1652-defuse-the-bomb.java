class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] arr = new int[n];
        if(k>0){
            for(int i=0;i<n;i++){
                int sum=0;
                int index=i;
                int k2=k;
                while(k2-->0) {
                    sum+=code[(index+1)%n];
                    index++;
                }
                arr[i]=sum;
            }
        }
        else if(k<0){
            for(int i=0;i<n;i++){
                int sum=0;
                int index=i+n;
                int k2=k;
                while(k2++<0) {
                    sum+=code[(index-1)%n];
                    index--;
                }
                arr[i]=sum;
            }
        }
        else{
            for(int i=0;i<n;i++) arr[i]=0;
        }
        return arr;
    }
}