class Solution {
    public String minWindow(String s, String t) {
        int[] hash = new int[256];
        for(int i=0;i<t.length();i++){
            hash[t.charAt(i)]++;
        }
        int r=0,l=0,cnt=0,minlen=Integer.MAX_VALUE,index=-1;
        while(r<s.length()){
            if(hash[s.charAt(r)]>0) cnt++;
            hash[s.charAt(r)]--;
            while(cnt==t.length()){
                if(r-l+1<minlen){
                    minlen=r-l+1;
                    index=l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)]>0) cnt--;
                l++;
            }
            r++;
        }
        return index==-1 ? "" : s.substring(index,index+minlen);
    }
}