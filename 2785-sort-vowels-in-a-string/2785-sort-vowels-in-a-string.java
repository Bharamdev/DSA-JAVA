class Solution {
    public String sortVowels(String s) {
        ArrayList<Character> ch = new ArrayList<>();
        String vowels = "aeiouAEIOU";
        for(char c: s.toCharArray()){
            if(vowels.indexOf(c) >= 0) ch.add(c);
        }
        Collections.sort(ch);
        int idx=0;
        StringBuilder res = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(vowels.indexOf(c) >= 0){
                res.append(ch.get(idx++));
            }
            else res.append(c);
        }
        return res.toString();
    }
}