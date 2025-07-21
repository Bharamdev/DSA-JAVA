class Solution {
    public String makeFancyString(String s) {
     int cnt=1;
     StringBuilder str = new StringBuilder();
     str.append(s.charAt(0));
     for(int i=1;i<s.length();i++){
        if(s.charAt(i)==s.charAt(i-1)) cnt++;
        else cnt=1;
        if(cnt<3) str.append(s.charAt(i));
     }   
     return str.toString();
    }
}