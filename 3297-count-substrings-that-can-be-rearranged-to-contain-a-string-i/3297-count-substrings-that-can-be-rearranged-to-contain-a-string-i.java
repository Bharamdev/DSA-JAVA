class Solution {
    public long validSubstringCount(String word1, String word2) {
        int n=word1.length(), m=word2.length();
        // int[] need = new int[26];
    //     Map<Character,Integer> need = new HashMap<>();
    //     for(char ch: word2.toCharArray()) need.put(ch, need.getOrDefault(ch,0)+1);
    //     int size=need.size();
    //     // int[] check = new int[26];
    //     Map<Character,Integer> map = new HashMap<>();
    //     int l=0;
    //     long cnt=0;
    //     for(int r=0;r<n;r++){
    //         char ch = word1.charAt(r);
    //         map.put(ch, map.getOrDefault(ch,0)+1);
    //         while(map.size()>=size && isValid(map,need)){
    //             char c=word1.charAt(l);
    //             cnt+=n-r;
    //             map.put(c,map.get(c)-1);
    //             if(map.get(c)==0) map.remove(c);
    //             l++;
    //         }
    //     }
    //         return cnt;
    // }
    // public boolean isValid(Map<Character,Integer> map, Map<Character,Integer> need){
    //     for(char key: need.keySet()){
    //         int check = map.getOrDefault(key,0); 
    //         if(check < need.get(key)) return false;
    //     }
    //     return true;

    int[] need = new int[26];
    int required = 0;
    for(char ch: word2.toCharArray()) {
        if(need[ch-'a']==0) required++;
        need[ch-'a']++;
    }
    int l=0;
    int[] check = new int[26];
    long cnt=0;
    int match=0;
    for(int r=0;r<n;r++){
        int rIdx = word1.charAt(r)-'a';
        check[rIdx]++;
        if(check[rIdx]==need[rIdx]) match++;
        while(match==required){
            cnt+=n-r;
            int lIdx = word1.charAt(l)-'a';
            if(check[lIdx]==need[lIdx]) match--;
            check[lIdx]--;
            l++;
        }
    }
        return cnt; 
    }
}