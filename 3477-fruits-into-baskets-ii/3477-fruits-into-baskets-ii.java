class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(baskets[j]>=fruits[i]){
                    cnt++;
                    baskets[j]=0;
                    break;
                }
            }
        }
        return n-cnt;
    }
}