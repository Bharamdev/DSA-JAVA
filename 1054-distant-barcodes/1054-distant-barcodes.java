class Solution {
    class pair{
        int num;
        int freq;
        pair(int num,int freq){
            this.num = num;
            this.freq=freq;
        }
    }
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        int[] arr = new int[n];
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> {
            if(a.freq!=b.freq) return b.freq-a.freq;
            else return a.num-b.num;
        });
        Map<Integer,Integer> map = new HashMap<>();
        for(int barcode: barcodes) map.put(barcode, map.getOrDefault(barcode,0)+1);
        for(int key: map.keySet()){
            pq.offer(new pair(key,map.get(key)));
        }
        int i=0;
        while(!pq.isEmpty()){
            pair fst = pq.poll();
            arr[i++]=fst.num;
            fst.freq--;
            if(!pq.isEmpty()){
                pair scnd = pq.poll();
                arr[i++]=scnd.num;
                scnd.freq--;
                if(scnd.freq>0) pq.offer(scnd);
            }
            if(fst.freq>0) pq.offer(fst);
        } 
        return arr;
    }
}