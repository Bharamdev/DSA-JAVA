class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int pos=1, neg=-1;
        if(n%2!=0){
            arr[0]=0;
            for(int i=1;i<n;i+=2){
                arr[i]=pos;
                arr[i+1]=neg;
                pos+=1;
                neg-=1;
            }
        }
        else{
            for(int i=0;i<n;i+=2){
                arr[i]=pos;
                arr[i+1]=neg;
                pos+=1;
                neg-=1;
            }
        }
        return arr;
    }
}