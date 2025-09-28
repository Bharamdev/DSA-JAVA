class Solution {
    public String majorityFrequencyGroup(String s) {
        int[] freq = new int[26];
        int[] size = new int[26];
        for(char ch: s.toCharArray()) freq[ch-'a']++;
        for(int i: freq){
            if(i>0) size[i]++;
        }
        int maxFreq = 0, maxSize=0;
        for(int i=0;i<26;i++){
            int f = i;
            int S = size[i];
            if(S > maxSize || (S==maxSize && f>maxFreq)){
                maxSize = S;
                maxFreq = f;
            }
        }
        StringBuilder str = new StringBuilder();
        for(int i=0;i<26;i++){
            if(freq[i]==maxFreq){
                char c = (char)(i+'a');
                str.append(c);
            }
        }
        return str.toString();
    }
}