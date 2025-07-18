class Solution {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums) map.put(num,map.getOrDefault(num,0)+1);
        List<Integer> res = new ArrayList<>();
        for(int key: map.keySet()){
            if(map.get(key)<2 && (!map.containsKey(key-1) && !map.containsKey(key+1))){
                res.add(key);
            }
        }
        return res;
    }
}