class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n=arr.length;
        int i=n-2;
        while(i>=0 && arr[i]<=arr[i+1]){
            i--;
        }
        if(i<0) return arr;
        int j=n-1;
        while(j>i){
            if(arr[i]>arr[j]){
                while(j-1>i && arr[j-1]==arr[j]){
                    j--;
                }
                break;
            }
            j--;
        }
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return arr;

    }
}