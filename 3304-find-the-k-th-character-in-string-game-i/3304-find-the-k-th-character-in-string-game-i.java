class Solution {
    public char kthCharacter(int k) {
        StringBuilder str = new StringBuilder("a");
        while(str.length()<k){
            StringBuilder word = new StringBuilder();
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                char nextChar = (char)((ch+1-'a')%26 + 'a');
                word.append(nextChar);
            }
            str.append(word);
        }
        return str.charAt(k-1);
    }
}