class Solution {
    public int characterReplacement(String s, int k) {
        int r=0,l=0,maxlen=0;
        // Map<Character,Integer> map= new HashMap<>();
        int[] count = new int[26];
        int maxfreq=0;
        while(r<s.length()){
            // map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            count[s.charAt(r)-'A']++;
            maxfreq= Math.max(maxfreq,count[s.charAt(r)-'A']);
            int len = r-l+1; 
            if(len-maxfreq>k){
               count[s.charAt(l)-'A']--;
                l++;
            }
            if( len - maxfreq <= k ) maxlen = Math.max(maxlen,len);
            r++;
        }
        return maxlen;
    }
}