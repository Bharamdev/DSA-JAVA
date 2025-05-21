class Solution {
    static char nonRepeatingChar(String s) {
        // code here
        Map<Character,Integer> map = new HashMap<>();
        int n=s.length();
        for(char ch: s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch: s.toCharArray()){
            if(map.get(ch)==1){
                return ch;
            }
        }
        return '$';
    }
}
