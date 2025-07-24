class Solution {
    public int partitionString(String s) {
        int[] freq = new int[26];
        int cnt=1;
        int l=0;
        for(int r=0;r<s.length();r++){
            char ch = s.charAt(r);
            int i = ch-'a';
            if(freq[i]>=1) {
                cnt++;
                while(l<r) {
                    freq[s.charAt(l)-'a']--;
                    l++;
                }
            }
            freq[i]++;
        }
        return cnt;
    }
}