class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        Map<Character,Integer> map = new HashMap<>();
        int j=0;
        int n=s.length();
        int maxLen=-1;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size()>k){
                char c = s.charAt(j);
                map.put(c,map.get(c)-1);
                if(map.get(c)==0) map.remove(c);
                j++;
            }
            if(map.size()==k) maxLen = Math.max(maxLen,i-j+1);
        }
        return maxLen;
    }
}