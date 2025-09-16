class Solution {
    public boolean stringStack(String pat, String tar) {
        // code here
        int pSize = pat.length();
        int tSize = tar.length();
        int i=pSize-1,j=tSize-1;
        while(i>=0 && j>=0){
            char ch1 = pat.charAt(i);
            char ch2 = tar.charAt(j);
            if(ch1==ch2){
                i--;
                j--;
            }
            else{
                i-=2;
            }
            if(j==-1) return true;
        }
        return j==-1;
    }
}
