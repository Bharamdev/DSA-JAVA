class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> mpp1 = new HashMap<>();
        HashMap<Character, Integer> mpp2 = new HashMap<>();
        for(int i=0; i<s.length(); i++){
           mpp1.put(s.charAt(i), mpp1.getOrDefault(s.charAt(i),0) + 1);
           mpp2.put(t.charAt(i), mpp2.getOrDefault(t.charAt(i),0) + 1);
        }
        return mpp1.equals(mpp2);
    }
}