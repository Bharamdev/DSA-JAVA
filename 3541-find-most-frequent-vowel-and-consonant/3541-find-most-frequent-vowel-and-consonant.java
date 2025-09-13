class Solution {
    public int maxFreqSum(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()) map.put(ch, map.getOrDefault(ch,0)+1);
        int vowel=0, consonant=0;
        for(char ch: s.toCharArray()){
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                vowel = Math.max(vowel, map.get(ch));
            }
            else{
                consonant = Math.max(consonant, map.get(ch));
            }
        }
        return vowel+consonant;
    }
}