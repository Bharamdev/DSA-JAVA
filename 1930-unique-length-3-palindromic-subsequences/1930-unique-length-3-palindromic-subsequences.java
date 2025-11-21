class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        int cnt=0;
        Arrays.fill(first,-1);
        for(int i=0;i<n;i++){
            int c = s.charAt(i)-'a';
            if(first[c]==-1) first[c]=i;
            last[c]=i;
        }
        for(int i=0;i<26;i++){
            if(first[i]==-1 || first[i]==last[i]) continue;

            boolean[] middle = new boolean[26];
            for(int j=first[i]+1; j<last[i]; j++){
                middle[s.charAt(j)-'a'] = true;
            }
            for(boolean exist: middle){
                if(exist) cnt++;
            }
        }
        return cnt;
    }
}