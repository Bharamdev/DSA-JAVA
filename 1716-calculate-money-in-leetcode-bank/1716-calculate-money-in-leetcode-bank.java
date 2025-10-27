class Solution {
    public int totalMoney(int n) {
        int total=0;
        int t=n;
        for(int i=0; i<=n/7; i++){
            int k=i+1;
            for(int j=0;j<Math.min(t,7);j++) total+=k++;
            t-=7;
        }
        return total;
    }
}