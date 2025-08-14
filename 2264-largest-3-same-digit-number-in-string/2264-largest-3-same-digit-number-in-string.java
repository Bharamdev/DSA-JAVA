class Solution {
    public String largestGoodInteger(String num) {
        StringBuilder str = new StringBuilder();
        int cnt=1;
        int integer = -1;
        char res = ' ';
        for(int i=1;i<num.length();i++){
            char curr = num.charAt(i);
            char prev = num.charAt(i-1);
            if(curr == prev) cnt++;
            else cnt=1;
            if(cnt==3 && (curr-'0') > integer){
                integer = curr-'0';
                res = curr;
            }
        }
        if(res != ' '){
            for(int i=0;i<3;i++) str.append(res);
        }
        return str.toString();
    }
}