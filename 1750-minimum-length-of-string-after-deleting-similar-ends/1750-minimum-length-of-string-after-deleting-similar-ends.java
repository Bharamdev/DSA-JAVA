class Solution {
    public int minimumLength(String s) {
        int n=s.length();
        int l=0,r=n-1;
        while(l<r && s.charAt(l)==s.charAt(r)){
            char  ch=s.charAt(r);
            while(l<=r && s.charAt(l)==ch) l++;
            while(l<=r && s.charAt(r)==ch) r--;
        }
        return r-l+1;
    }
}