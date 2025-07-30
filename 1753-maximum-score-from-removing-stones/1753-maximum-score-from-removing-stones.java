class Solution {
    public int maximumScore(int a, int b, int c) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // pq.offer(a);
        // pq.offer(b);
        // pq.offer(c);
        // int cnt=0;
        // while(pq.size()>1){
        //     int x = pq.poll()-1;
        //     int y = pq.poll()-1;
        //     cnt++;
        //     if(x>0) pq.offer(x);
        //     if(y>0) pq.offer(y);
        // }
        // return cnt;
        int[] arr = {a,b,c};
        Arrays.sort(arr);
        if(arr[0]+arr[1]<=arr[2]) return arr[0]+arr[1];
        else return arr[2]+(arr[0]+arr[1]-arr[2])/2;
    }
}