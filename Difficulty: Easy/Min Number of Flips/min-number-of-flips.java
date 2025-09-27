class Solution {
    public int minFlips(String s) {
        // Code here
        int flip1=0; // 01010101....
        int flip2=0; // 10101010....
        for(int i=0;i<s.length();i++){
            char expected1 = (i%2==0) ? '0' : '1';
            char expected2 = (i%2==0) ? '1' : '0';
            if(s.charAt(i) != expected1) flip1++;
            if(s.charAt(i) != expected2) flip2++;
        }
        return Math.min(flip1, flip2);
    }
}