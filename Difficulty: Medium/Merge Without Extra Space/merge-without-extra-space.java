class Solution {
    public void mergeArrays(int a[], int b[]) {
        // code here
        int n = a.length;
        int m=b.length;
        int i=n-1,j=0;
        while(i>=0 && j<m){
            if(a[i]>b[j]) swap(a,b,i,j);
            else break;
            i--;
            j++;
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }
    public void swap(int[] a, int[] b, int i, int j){
        int temp = a[i];
        a[i]=b[j];
        b[j]=temp;
    }
}
