class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        String[] str = s.split(" ");
        if(pattern.length()!=str.length) return false; 
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            String word = str[i];
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(ch).equals(word)) return false;
            }
            else{
                if(set.contains(word)) return false;
                map.put(ch,word);
                set.add(word);
            }
        }
        return true;
    }
}