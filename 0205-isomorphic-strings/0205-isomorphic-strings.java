class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mpp = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(!mpp.containsKey(s.charAt(i))){
                if(!mpp.containsValue(t.charAt(i))){
                    mpp.put(s.charAt(i), t.charAt(i));
                }
                else{
                    return false;
                }
            }
            else{
                char test = mpp.get(s.charAt(i));
                if(t.charAt(i) != test) return false;
            }
        }
        return true;
    }
}