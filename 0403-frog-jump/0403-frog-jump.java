class Solution {
    HashMap<String, Boolean> memo;
    public boolean canCross(int[] stones) {
        int n = stones.length;
        Set<Integer> set = new HashSet<>();
        for(int i: stones) set.add(i);
        memo = new HashMap<>();
        return fn(0,0,n,stones,set);
    }
    boolean fn(int index, int k, int n, int[] stones, Set<Integer> set){
        if(index==stones[n-1] ) return true;
        String key = index+","+k;
        if(map.containsKey(key)) return map.get(key);
        for(int jump=k-1; jump<=k+1; jump++){
            if(jump<=0) continue;
            int pos = index+jump;
            if(set.contains(pos)){
                if(fn(pos, jump, n, stones, set)){
                    map.put(key,true);
                    return true;
                }
            }
        }
        map.put(key,false);
        return false;
    }
}