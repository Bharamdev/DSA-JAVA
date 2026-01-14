class Solution {
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int x=0;x<n;x++){
            char ch = s.charAt(x);
            if(ch=='?'){
                for(char c='a'; c<='z';c++){
                    if(x>0 && sb.charAt(sb.length()-1)==c) continue;
                    if(x<n-1 && s.charAt(x+1)==c) continue;
                    sb.append(c);
                    break;
                }
                        
            }
            else sb.append(ch);
        }
        return sb.toString();
    }
}