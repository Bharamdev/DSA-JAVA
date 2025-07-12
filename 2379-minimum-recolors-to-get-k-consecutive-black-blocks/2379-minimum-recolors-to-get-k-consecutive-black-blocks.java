class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n=blocks.length();
        int wCnt=0;
        for(int i=0;i<k;i++){
            char ch = blocks.charAt(i);
            if(ch=='W') wCnt++;
        }
        int cnt = wCnt;
       for(int i=k;i<n;i++){
            if(blocks.charAt(i)=='W') wCnt++;
            if(blocks.charAt(i-k)=='W') wCnt--;
            cnt=Math.min(cnt,wCnt);
        }
        return cnt;
    }
}