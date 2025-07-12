class Solution {
    public int countHomogenous(String s) {
        int MOD = 1_000_000_007;
        long cnt=0;
        int l=0;
        for(int r=0;r<s.length();r++){
            if(r>0 && s.charAt(r)==s.charAt(r-1)){
                cnt+=r-l+1;
            }
            else{
                cnt++;
                l=r;
            }
        }
        return (int)(cnt%MOD);
    }
}