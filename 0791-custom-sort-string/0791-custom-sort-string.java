class Solution {
    public String customSortString(String order, String s) {
        // Map<Character,Integer> map = new HashMap<>();
        // for(char ch: s.toCharArray()) map.put(ch, map.getOrDefault(ch,0)+1);
        // StringBuilder str = new StringBuilder();
        // for(char ch: order.toCharArray()){
        //     if(map.containsKey(ch)){
        //         int cnt=map.get(ch);
        //         for(int i=0;i<cnt;i++){
        //             str.append(ch);
        //         }
        //         map.remove(ch);
        //     }
        // }
        // for(char key: map.keySet()){
        //     for(int i=0;i<map.get(key);i++) str.append(key);
        // }
        // return str.toString();

        // Optimize 
        int[] freq = new int[26];
        for(char ch: s.toCharArray()) freq[ch-'a']++;
        StringBuilder str = new StringBuilder();
        for(char ch: order.toCharArray()){
            if(freq[ch-'a']>0){
                int cnt=freq[ch-'a'];
                for(int i=0;i<cnt;i++){
                    str.append(ch);
                    freq[ch-'a']--;
                }
            }
        }
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                for(int j=0;j<freq[i];j++){
                    str.append((char)(i+'a'));
                }
            }
        }
        return str.toString();
    }
}