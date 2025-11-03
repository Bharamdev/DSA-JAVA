// User function Template for Java

class Solution {
    class pair{
        int step;
        int node;
        pair(int step, int node){
            this.step=step;
            this.node=node;
        }
    }
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        int mod=100000;
        int[] step = new int[mod];
        Arrays.fill(step,Integer.MAX_VALUE);
        step[start]=0;
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(0,start));
        while(!q.isEmpty()){
            int num = q.peek().node;
            int steps = q.poll().step;
            if(num==end) return steps;
            for(int a: arr){
                int mul = (num*a)%mod;
                if(steps+1<step[mul]){
                     step[mul]=steps+1;
                     q.offer(new pair(steps+1,mul));
                }
            }
        }
        return -1;
    }
}
