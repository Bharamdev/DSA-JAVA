class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            pq.offer(new int[]{nums.get(i).get(0), i, 0});
            max=Math.max(max,nums.get(i).get(0));
        }
        int[] range = new int[]{0,Integer.MAX_VALUE};
        while(true){
            int[] arr = pq.poll();
            int min = arr[0], currList = arr[1], eleIndex=arr[2];
            if(max-min < range[1]-range[0]){
                range[0]=min;
                range[1]=max;
            }
            if(eleIndex+1 < nums.get(currList).size()){
                int nextVal=nums.get(currList).get(eleIndex+1);
                pq.offer(new int[]{nextVal,currList,eleIndex+1});
                max=Math.max(max,nextVal);
            }
            else break;
        }
        return range;
    }
}