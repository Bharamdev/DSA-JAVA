class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize!=0) return false;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int maxcnt = n/groupSize;
        for(int i: hand){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        while(!map.isEmpty()){
            int num = map.firstKey();  
            for(int i=0;i<groupSize;i++){
                int card = num+i;
                if(!map.containsKey(card)) return false;
                map.put(card,map.get(card)-1);
                if(map.get(card)<=0) map.remove(card);
            }
        }
        return true;
    }
}