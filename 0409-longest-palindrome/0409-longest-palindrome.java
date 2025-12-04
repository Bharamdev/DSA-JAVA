class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        int len=0,odd=0;
        for(int val: map.values()){
            if(val%2==0) len+=val;
            else{
                len+=val-1;
                odd=1;
            }
        }
        return len+odd;
    }
}