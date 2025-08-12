class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        // code here
        Arrays.sort(prices);
        ArrayList<Integer> arr = new ArrayList<>();
        int n=prices.length;
        int i=0,j=n-1;
        int min=0;
        while(i<=j){
            min+=prices[i];
            i++;
            j-=k;
        }
        arr.add(min);
        i=0;
        j=n-1;
        int max=0;
        while(i<=j){
            max+=prices[j];
            j--;
            i+=k;
        }
        arr.add(max);
        return arr;
    }
}
