class Solution {
    public int characterReplacement(String s, int k) {
        int r=0,l=0,maxlen=0;
        Map<Character,Integer> map= new HashMap<>();
        int maxfreq=0;
        while(r<s.length()){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            for(int i: map.values()) maxfreq= Math.max(maxfreq,i);
            int len = r-l+1; 
            if( len - maxfreq <= k ) maxlen = Math.max(maxlen,len);
            if(len-maxfreq>k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;
            }
            r++;
        }
        return maxlen;
    }
}