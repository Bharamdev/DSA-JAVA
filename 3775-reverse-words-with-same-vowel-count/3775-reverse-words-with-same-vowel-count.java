class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        int vowels = countVowels(str[0]);
        StringBuilder sb = new StringBuilder();
        sb.append(str[0]);
        if(str.length > 1) sb.append(" ");
        for(int i=1;i<str.length;i++){
            if(countVowels(str[i])==vowels){
                String rev = reverse(str[i]);
                sb.append(rev);
                if(i<str.length-1) sb.append(" ");
            }
            else{
                sb.append(str[i]);
                if(i<str.length-1) sb.append(" ");
            }
        }
        return sb.toString();
    }
    int countVowels(String s){
        int cnt=0;
        for(char ch: s.toCharArray()){
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') cnt++;
        }
        return cnt;
    }
    String reverse(String s){
        String rev="";
        for(int i=s.length()-1;i>=0;i--){
            rev+=s.charAt(i);
        }
        return rev;
    }
}