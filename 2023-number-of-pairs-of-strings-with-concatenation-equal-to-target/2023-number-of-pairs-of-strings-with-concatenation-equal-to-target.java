class Solution {
    public int numOfPairs(String[] nums, String target) {
        int cnt=0;
        Map<String,Integer> map = new HashMap<>();
        for(String s: nums) map.put(s, map.getOrDefault(s,0)+1);
        for(String s: nums){
            if(target.startsWith(s)){
                int len = s.length();
                String sub = target.substring(len);  // Suffix String
                if(map.containsKey(sub)){
                    cnt+=map.get(sub);
                }
                if(s.equals(sub)) cnt--;
            }
        }
        return cnt;
    }
}