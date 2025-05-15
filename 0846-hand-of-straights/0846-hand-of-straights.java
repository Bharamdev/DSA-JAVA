class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        Arrays.sort(hand);
        if(n%groupSize!=0) return false;
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxcnt = n/groupSize;
        for(int i: hand){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        for(int num : hand){
            if(!map.containsKey(num)) continue;  
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