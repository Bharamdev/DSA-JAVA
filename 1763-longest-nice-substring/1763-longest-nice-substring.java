class Solution {
    public String longestNiceSubstring(String s) {
        int n=s.length();
        int len=0;
        String res = "";
        for(int i=0;i<n;i++){
            int[] small = new int[26];
            int[] big = new int[26];
            for(int j=i;j<n;j++){
                char ch = s.charAt(j);
                if(Character.isLowerCase(ch)){
                    small[ch-'a']++;
                }
                else{
                    big[ch-'A']++;
                }
                if(isNice(small,big)) {
                    if(j-i+1>len){
                        len=j-i+1;
                        res = s.substring(i,j+1);
                    }
                }
            }
        }
        return res;
    }
    public boolean isNice(int[] small , int[] big){
        for(int i=0;i<26;i++){
            if((small[i]>0 && big[i]==0) || (big[i]>0 && small[i]==0)) return false;
        }
        return true;
    }
}