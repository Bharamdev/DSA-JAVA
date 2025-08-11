class Solution {
    public String customSortString(String order, String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()) map.put(ch, map.getOrDefault(ch,0)+1);
        StringBuilder str = new StringBuilder();
        for(char ch: order.toCharArray()){
            if(map.containsKey(ch)){
                str.append(ch);
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)<=0) map.remove(ch);
            }
        }
        for(char key: map.keySet()){
            for(int i=0;i<map.get(key);i++) str.append(key);
        }
        return str.toString();
    }
}