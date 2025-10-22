class Solution {
    public void nearlySorted(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<=Math.min(arr.length-1,k);i++){
            pq.offer(arr[i]);
        }
        int index=0;
        for(int i=k+1;i<arr.length;i++){
            arr[index++]=pq.poll();
            pq.offer(arr[i]);
        }
        while(!pq.isEmpty()) arr[index++]=pq.poll();
    }
}
