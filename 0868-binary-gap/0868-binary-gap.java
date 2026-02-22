class Solution {
    public int binaryGap(int n) {
        int max=0;
        int pos=0, last=-1;
        while(n>0){
            if((n&1)==1){
                if(last!=-1){
                    max = Math.max(max, pos-last);
                }
                last=pos;
            }
            pos++;
            n = n>>1;
        }
        return max;
    }
}