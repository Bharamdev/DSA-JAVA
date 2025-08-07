class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);
            if(!map.containsKey(sorted)) map.put(sorted, new ArrayList<>());
            map.get(sorted).add(str);
        }
        List<List<String>> res = new ArrayList<>(map.values());
        return res; 
    }
}