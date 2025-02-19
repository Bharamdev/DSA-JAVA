class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n= piles.length, sum=0;
        // for(int i=0; i<n; i+=2){
        //     // if(n-i>=0){
        //     //     sum+=piles[n-1-i];
        //     // }
        // }
        int i=0, j=n-1;
        while(i<=j){
            sum+=piles[j-1];
            j-=2;
            i++;
        }
        return sum;
    }
}