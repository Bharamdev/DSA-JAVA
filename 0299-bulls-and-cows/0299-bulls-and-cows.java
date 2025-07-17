class Solution {
    public String getHint(String secret, String guess) {
        int[] freq = new int[10];
        for(char ch: secret.toCharArray()) freq[ch-'0']++;
        int bulls=0,cows=0;
        for(int i=0;i<secret.length();i++){
            int s = secret.charAt(i)-'0';
            int g = guess.charAt(i)-'0';
            if(s==g){
                bulls++;
                if(freq[g]>0) freq[g]--;
                else {
                    cows--;
                }
            }
            else{
                if(freq[g]>0){
                    freq[g]--;
                    cows++;
                }
            }
        }
        String ans = "";
        ans += bulls+"A"+cows+"B";
        return ans;
    }
}