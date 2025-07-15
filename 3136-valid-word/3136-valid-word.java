class Solution {
    public boolean isValid(String word) {
        int n=word.length();
        boolean vowel=false;
        boolean consonant = false;
        if(n<3) return false;
        String str = "aeiouAEIOU";
        for(char ch: word.toCharArray()){
            if(!Character.isLetterOrDigit(ch)) return false;
            else if(Character.isLetter(ch)){
                if(str.indexOf(ch)!=-1) vowel=true;
                else consonant=true;
            }
        }
        return vowel && consonant;
    }
}