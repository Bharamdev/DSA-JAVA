class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Map<Character,Integer> map = new HashMap<>();
        // for(char ch: magazine.toCharArray()) map.put(ch, map.getOrDefault(ch,0)+1);
        // for(char ch: ransomNote.toCharArray()){
        //     if(map.getOrDefault(ch,0)>0){
        //         map.put(ch,map.get(ch)-1);
        //         if(map.get(ch)==0) map.remove(ch);
        //     }
        //     else return false;
        // }
        // return true;

        // Optimize 
        int[] freq = new int[26]; 
        for(char ch: magazine.toCharArray()) freq[ch-'a']++;
        for(char ch: ransomNote.toCharArray()){
            if(freq[ch-'a']>0) freq[ch-'a']--;
            else return false;
        }
        return true;
    }
}