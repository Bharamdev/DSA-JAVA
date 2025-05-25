class Solution {
    public int longestPalindrome(String[] words) {
        Map<String,Integer> map = new HashMap<>();
        for(String str:words){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        int cnt=0;
        boolean center=false;
        for(String word: map.keySet()){
            String rev = new StringBuilder(word).reverse().toString();
            int freq = map.get(word);
            if(freq==0) continue;
            if(word.equals(rev) ){
                cnt+=(freq/2)*4;
                center=true;
            }
            else if(map.containsKey(rev) ){
                int pair = Math.min(freq,map.get(rev)) ;
                cnt+= pair*4;
                map.put(rev,0);
            }
            map.put(word,0);
        }
        if(center) cnt+=2;
        return cnt;
    }
}