class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int truelen=0,falselen=0;
        int n=answerKey.length();
        int cnt=0,l=0;
        for(int r=0;r<n;r++){
           char ch=answerKey.charAt(r);
           if(ch=='F') cnt++;
           while(cnt>k){
               if(answerKey.charAt(l)=='F') cnt--;
               l++;
           }
           truelen=Math.max(truelen,r-l+1);
        }
        cnt=0;
        l=0;
        for(int r=0;r<n;r++){
           char ch=answerKey.charAt(r);
           if(ch=='T') cnt++;
           while(cnt>k){
               if(answerKey.charAt(l)=='T') cnt--;
               l++;
           }
           falselen=Math.max(falselen,r-l+1);
        }
        return Math.max(truelen,falselen);
    }
}