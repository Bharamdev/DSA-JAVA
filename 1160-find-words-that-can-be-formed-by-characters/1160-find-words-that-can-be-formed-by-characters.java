class Solution {
    public int countCharacters(String[] words, String chars) {
        int len=0;
        // Map<Character,Integer> map = new HashMap<>();
        // for(char ch : chars.toCharArray()) map.put(ch,map.getOrDefault(ch,0)+1);
        // for(String str: words){
        //     Map<Character,Integer> copy = new HashMap<>(map);
        //     boolean good = true;
        //     for(char ch: str.toCharArray()){
        //         if(copy.getOrDefault(ch,0)<=0){
        //             good=false;
        //             break;
        //         }
        //         copy.put(ch,copy.getOrDefault(ch,0)-1);
        //     }
        //     if(good) len+=str.length();
        // }

        // Optimize
        int[] freq = new int[26];
        for(char ch: chars.toCharArray()) freq[ch-'a']++;
        for(String str: words){
            int[] curr = new int[26];
            boolean good = true;
            for(char ch: str.toCharArray()){
                curr[ch-'a']++;
                if(curr[ch-'a']>freq[ch-'a']){
                    good=false;
                    break;
                }
            }
            if(good) len+=str.length();
        }
        return len;
    }
}