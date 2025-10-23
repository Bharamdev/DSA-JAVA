class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length()>2){
            s = newS(s);
        }
        return s.charAt(0)==s.charAt(1);
    }
    String newS(String s){
        StringBuilder str = new StringBuilder();
        for(int i=0;i<s.length()-1;i++){
            int d1 = s.charAt(i) - '0';
            int d2 = s.charAt(i + 1) - '0';
            int sum = (d1 + d2) % 10; 
            str.append(sum);
        }
        return str.toString();
    }
}