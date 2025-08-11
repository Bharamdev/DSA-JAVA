class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        int[][] arr = new int[profit.length][2];
        for(int i=0;i<profit.length;i++){
            arr[i][0]=difficulty[i];
            arr[i][1]=profit[i];
        }
        Arrays.sort(arr,(a,b) -> a[0]-b[0]);
        int sum=0;
        for(int i=0;i<worker.length;i++){
            int maxProfit=0;
            for(int p=0;p<arr.length;p++){
                if(worker[i]>=arr[p][0]) maxProfit = Math.max(maxProfit,arr[p][1]);
            }
            sum+=maxProfit;
        }
        return sum;
    }
}