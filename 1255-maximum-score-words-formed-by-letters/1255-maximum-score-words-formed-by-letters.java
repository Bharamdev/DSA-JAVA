class Solution {
    int[] freq = new int[26];
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        for(char ch: letters) freq[ch-'a']++;
        return fn(0, words, letters, score);
    }
    int fn(int idx, String[] words, char[] letters, int[] score){
        if(idx==words.length) return 0;
        int sno = 0 + fn(idx+1, words, letters, score);
        int sword = 0;
        boolean flag = true;
        String word = words[idx];
        for(char ch: word.toCharArray()){
            if(freq[ch-'a']==0) flag=false;
            freq[ch-'a']--;
            sword+=score[ch-'a'];
        }

        int syes=0;
        if(flag){
            syes = sword + fn(idx+1, words, letters, score);
        }
        
        for(char ch: word.toCharArray()){
            freq[ch-'a']++;
        }

        return Math.max(syes, sno);
    }
}