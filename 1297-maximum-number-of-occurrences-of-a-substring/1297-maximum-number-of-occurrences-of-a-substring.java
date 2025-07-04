class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<Character,Integer> map = new HashMap<>();
        Map<String, Integer> ans = new HashMap<>();
        int n=s.length();
        int r=0,l=0;
        while(r<n){
            char c= s.charAt(r);
            map.put(c,map.getOrDefault(c,0)+1);
            if( r-l+1>minSize){
                char ch = s.charAt(l);
                map.put(ch,map.get(ch)-1);
                l++;
                if(map.get(ch)<1) map.remove(ch);
            }
            if(map.size()<=maxLetters &&  r-l+1==minSize){
                String sub = s.substring(l,r+1);
                ans.put(sub,ans.getOrDefault(sub,0)+1);
            }
            r++;
        }
        int result=0;
        for(int i: ans.values()) result= Math.max(result,i);
        return result;
    }
}