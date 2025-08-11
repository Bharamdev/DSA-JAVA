class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        int n=profit.length;
        int[][] arr = new int[profit.length][2];
        for(int i=0;i<profit.length;i++){
            arr[i][0]=difficulty[i];
            arr[i][1]=profit[i];
        }
        Arrays.sort(arr,(a,b) -> a[0]-b[0]);
        int sum=0;
        int maxProfit=0;
        int index=0;
        for(int i=0;i<worker.length;i++){
            while(index<n && worker[i]>=arr[index][0]){
                maxProfit = Math.max(maxProfit,arr[index][1]);
                index++;
            }
            sum+=maxProfit;
        }
        return sum;
    }
}