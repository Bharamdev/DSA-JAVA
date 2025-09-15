class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int[] freq = new int[26];
        for(char ch: brokenLetters.toCharArray()) freq[ch-'a']++;
        int cnt=0;
        String[] s = text.split(" ");
        for(String str: s){
            if(!helper(str, freq)) cnt++;
        }
        return cnt;
    }
    boolean helper(String str, int[] freq){
        for(char ch: str.toCharArray()){
            if(freq[ch-'a'] > 0) return true; 
        }
        return false;
    }
}