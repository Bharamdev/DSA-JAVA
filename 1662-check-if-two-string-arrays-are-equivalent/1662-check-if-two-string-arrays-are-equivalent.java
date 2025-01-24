class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder w1 = new StringBuilder();
        StringBuilder w2 = new StringBuilder();
        for(int i=0; i<word1.length; i++){
            w1.append(word1[i]);
        }
        for(int i=0; i<word2.length; i++){
            w2.append(word2[i]);
        }
        return w1.toString().equals(w2.toString());
    }
}