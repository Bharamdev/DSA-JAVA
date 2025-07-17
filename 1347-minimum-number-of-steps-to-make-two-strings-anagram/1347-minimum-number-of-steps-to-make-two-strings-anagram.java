class Solution {
    public int minSteps(String s, String t) {
        int[] freq = new int[26];
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }
        int cnt=0;
        for(char ch: t.toCharArray()){
            if(freq[ch-'a']>0) freq[ch-'a']--;
        }
        for(int num: freq) cnt+=num;

        return cnt;
    }
}