class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n=customers.length;
        int res=0;
        for(int i=0;i<n;i++){
            if(grumpy[i]==0) res+=customers[i];
        }
        int max=0,sum=0;
        int r=0,l=0;
        while(r<n){
            if(grumpy[r]==1) sum+=customers[r];
            if(r-l>=minutes){
                if(grumpy[l]==1) sum-=customers[l];
                l++;
            }
            max=Math.max(max,sum);
            r++;
        }
        return res+max;
    }
}  