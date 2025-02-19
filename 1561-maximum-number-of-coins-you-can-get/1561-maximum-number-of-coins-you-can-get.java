class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n= piles.length, sum=0;
        int i=0, j=n-1;
        while(i<=j){
            sum+=piles[j-1];
            j-=2;
            i++;
        }
        return sum;
    }
}