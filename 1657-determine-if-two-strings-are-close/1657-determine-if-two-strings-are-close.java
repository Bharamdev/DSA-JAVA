class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        if(word1.length() != word2.length()) return false;
        for(char c : word1.toCharArray()) {
            f1[c - 'a']++;
        }
        for(char c : word2.toCharArray()) {
            f2[c - 'a']++;
        }
        for(int i=0;i<26;i++){
            if((f1[i]==0 && f2[i]!=0 ) || (f1[i]!=0 && f2[i]==0)){
                return false;
            }
        }
        Arrays.sort(f1);
        Arrays.sort(f2);
        for(int i=0;i<26;i++){
            if(f1[i] != f2[i]) return false;
        }
        return true;
    }
}