class Solution {
    class pair{
        int freq;
        int num;
        pair(int freq, int num){
            this.freq = freq;
            this.num = num;
        }
    }
    public int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        int[] arr = new int[n-k+1];
        int index=0;
        for(int i=0;i<=n-k;i++){
            Map<Integer,Integer> map = new HashMap<>();
            for(int j=i;j<i+k;j++){
                map.put(nums[j], map.getOrDefault(nums[j],0)+1);
            }
            PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> {
               if(a.freq==b.freq) return b.num-a.num;
               return b.freq-a.freq;
            });
            for(int key: map.keySet()) pq.offer(new pair(map.get(key), key)); 
            int sum=0;
            int size=pq.size();
            for(int j=0;j<Math.min(x,size);j++){
                pair p = pq.poll();
                sum+=(p.freq * p.num);
            }
            arr[index++]=sum;
        }
        return arr;
    }
}