class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        // Collections.sort(dictionary);
        String res= "";
        for(String str: dictionary){
            if(isEqualLength(s,str)){
                if(res.length()<str.length() || (res.length()==str.length() 
                && str.compareTo(res) < 0 )){
                    res=str;
                }
            }
        }
        return res;
    }
    public boolean isEqualLength(String s, String str){
        int i=0,j=0;
        int cnt=0;
        while(i<s.length() && j<str.length()){
            char char1 = s.charAt(i);
            char char2 = str.charAt(j);
            if(char1==char2){
                cnt++;
                i++;
                j++;
            }
            else i++;
        }
        return cnt==str.length();
    }
}