class Solution {
    public int substrCount(String s, int k) {
        // code here
        int[] freq = new int[26];
        int dist=0;
        int cnt=0;
        int l=0;
        for(int r=0;r<s.length();r++){
            int ch = s.charAt(r)-'a';
            if(freq[ch]==0) dist++;
            freq[ch]++;
            if(r-l+1 > k) {
                int c = s.charAt(l)-'a';
                freq[c]--;
                if(freq[c]==0) dist--;
                l++;
            }
            if(r-l+1==k && dist==k-1) cnt++;
        }
        return cnt;
    }
}