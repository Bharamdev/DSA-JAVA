class Solution {
    public int countSubstr(String s, int k) {
        //  code here
        return atMostK(s,k) - atMostK(s, k-1);
    }
    int atMostK(String s, int k){
        if(k==0) return 0;
        int[] freq = new int[26];
        int cnt=0;
        int dist=0;
        int l=0;
        for(int r=0;r<s.length();r++){
            int ch = s.charAt(r)-'a';
            if(freq[ch]++ == 0) dist++;
            while(dist>k){
                int c = s.charAt(l)-'a';
                freq[c]--;
                if(freq[c] == 0) dist--;
                l++;
            }
            cnt += r-l+1; 
        }
        return cnt;
    }
}