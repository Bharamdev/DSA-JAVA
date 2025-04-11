class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int gs=0,ss=0,ans=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(ss<s.length && gs < g.length){
            if(s[ss] >= g[gs]){
                gs++;
                ans++;
            }
            ss++;
        }
        return ans;
    }
}