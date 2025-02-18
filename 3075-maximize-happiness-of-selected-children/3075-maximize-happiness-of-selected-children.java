class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long sum=0; 
        int n = happiness.length;
        for(int i=0; i<k; i++){
            int index = n-1-i;
            // if(happiness[index] - i <= 0) break;
              int happinessValue = Math.max(0, happiness[index] - i);
            if (happinessValue == 0) break; 
            sum+= happiness[index] - i ;
            
        }
        return sum;
    }
}