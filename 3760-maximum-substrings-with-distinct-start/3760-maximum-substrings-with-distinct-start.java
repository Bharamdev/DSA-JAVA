class Solution {
    public int maxDistinct(String s) {
        boolean[] vis = new boolean[26];
        int cnt=0;
        for(char ch: s.toCharArray()){
            int i = ch-'a';
            if(!vis[i]) cnt++;
            vis[i]=true;
        }
        return cnt;
    }
}