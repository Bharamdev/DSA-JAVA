class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int r=0,l=0,cost=0;
        int n=s.length();
        int len=0;
        while(r<n){
            cost += Math.abs(s.charAt(r)-t.charAt(r));
            while(cost>maxCost){
                cost-= Math.abs(s.charAt(l)-t.charAt(l));
                l++;
            }
            len = Math.max(len, r-l+1);
            r++;
        }
        return len;
    }
}