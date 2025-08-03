class Solution {
    public char findTheDifference(String s, String t) {
        // Map<Character,Integer> map = new HashMap<>();
        // for(char ch: s.toCharArray()) map.put(ch,map.getOrDefault(ch,0)+1);
        // for(char ch: t.toCharArray()){
        //     map.put(ch,map.getOrDefault(ch,0)-1);
        //     if(map.get(ch)<0) return ch;
        // } 
        // return '1';

        // Optimize it
        char res = 0;
        for(char ch: s.toCharArray()) res^=ch;
        for(char ch: t.toCharArray()) res^=ch;
        return res; 
    }
}