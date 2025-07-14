class Solution {
    public int numberOfSubstrings(String s, int k) {
        int[] freq = new int[26];
        int n=s.length();
        int r=0,l=0;
        int cnt=0;
        while(r<n){
            int i = s.charAt(r)-'a';
            freq[i]++;
            while(freq[i]>=k){
                cnt+=n-r;
                freq[s.charAt(l)-'a']--;
                l++;
            }
            r++;
        }
        return cnt;
    }
}