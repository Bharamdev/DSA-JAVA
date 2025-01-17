class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int min=Integer.MAX_VALUE,Tsum=0,n=cardPoints.length;
        for(int i: cardPoints){
            Tsum += i;
        }
        if(n==k) return Tsum;
        int sum=0;
        int windowSize = n-k;
        for(int i=0; i<n; i++){
            sum+=cardPoints[i];
            if(i >= windowSize-1){
                min = Math.min(min, sum);
                sum -= cardPoints[i- windowSize+1];
            }
           
        }
        return Tsum-min;
        
    }
}