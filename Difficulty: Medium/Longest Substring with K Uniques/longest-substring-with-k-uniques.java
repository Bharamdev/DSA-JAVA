class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        Map<Character,Integer> map = new HashMap<>();
        int len=-1;
        int r=0,l=0;
        while(r<s.length()){
            char c = s.charAt(r);
            map.put(c,map.getOrDefault(c,0)+1);
            if(map.size()==k){
                len=Math.max(len,r-l+1);
            }
            while(map.size()>k){
                char ch = s.charAt(l);
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)<1) map.remove(ch);
                l++;
            }
            r++;
        }
        return len;
    }
}