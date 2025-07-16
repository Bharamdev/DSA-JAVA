class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        long sum=0;
        for(int num: shifts) sum+=num;
        StringBuilder str = new StringBuilder();
        for(int i=0;i<s.length();i++){
            int c = s.charAt(i)-'a';
            long updated = c+sum;
            char ch = (char)((updated%26)+'a');
            str.append(ch);
            sum-=shifts[i];
        }
        return str.toString();
    }
}