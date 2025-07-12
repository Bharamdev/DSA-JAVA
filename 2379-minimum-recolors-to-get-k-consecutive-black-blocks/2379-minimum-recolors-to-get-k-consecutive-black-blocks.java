class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n=blocks.length();
        int wCnt=0,bCnt=0;
        int cnt=101;
        for(int i=0;i<k;i++){
            char ch = blocks.charAt(i);
            if(ch=='W') wCnt++;
            // else bCnt++;
        }
        cnt=Math.min(cnt,wCnt);
        int r=k,l=0;
        while(r<n){
            if(blocks.charAt(r)=='W') wCnt++;
            // else bCnt++;
            if(blocks.charAt(l)=='W') wCnt--;
            cnt=Math.min(cnt,wCnt);
            r++;
            l++;
        }
        return cnt;
    }
}