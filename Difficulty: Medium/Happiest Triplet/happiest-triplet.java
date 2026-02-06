class Solution {
    int[] smallestDiff(int a[], int b[], int c[]) {
        // write code here
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int n = a.length;
        int[] ans = new int[3];
        int i=0, j=0, k=0;
        int x=0, y=0, z=0;
        int diff = Integer.MAX_VALUE;
        int sum = Integer.MAX_VALUE;
        while(i<n && j<n && k<n){
            int min = Math.min(a[i], Math.min(b[j],c[k]));
            int max = Math.max(a[i], Math.max(b[j], c[k]));
            int s = a[i]+b[j]+c[k];
            int d = max-min;
            if(d<diff || (d==diff && s<sum)){
                diff=d;
                sum=s;
                ans[0]=a[i];
                ans[1]=b[j];
                ans[2]=c[k];
            }
            if(a[i]==min) i++;
            else if(b[j]==min) j++;
            else k++;
        }
        Arrays.sort(ans);
        return new int[]{ans[2],ans[1],ans[0]};
    }
}
