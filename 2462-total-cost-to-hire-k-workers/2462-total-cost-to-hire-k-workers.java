class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n=costs.length;
        int right=n-1,left=0;
        long ans=0;
        PriorityQueue<int[]> pqRight = new PriorityQueue<>(
            (a,b) -> a[0]!=b[0] ? Integer.compare(a[0],b[0]) : Integer.compare(a[1],b[1])
        );
        PriorityQueue<int[]> pqLeft = new PriorityQueue<>((a,b)->
            a[0]!=b[0] ? Integer.compare(a[0],b[0]) : Integer.compare(a[1],b[1])
        );
        for(int i=0;i<candidates && left<=right; i++ , left++){
            pqLeft.offer(new int[]{costs[left],left});
        }
        for(int i=0;i<candidates && left<=right; i++ , right--){
            pqRight.offer(new int[]{costs[right],right});
        }
        for(int i=0;i<k;i++){
            if(pqRight.isEmpty() || (!pqLeft.isEmpty() && pqLeft.peek()[0]<=pqRight.peek()[0])){
                ans+=pqLeft.poll()[0];
                if(left<=right){
                    pqLeft.offer(new int[]{costs[left],left});
                    left++;
                }
            }
            else{
                ans+=pqRight.poll()[0];
                if(left<=right){
                    pqRight.offer(new int[]{costs[right],right});
                    right--;
                }
            }
        }
        return ans;
    }
}