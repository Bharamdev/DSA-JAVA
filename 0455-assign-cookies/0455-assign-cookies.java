class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int gs=0,ss=0,ans=0;
        Arrays.sort(g);
        Arrays.sort(s);
        if(s.length==0 || g.length==0) return 0;
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