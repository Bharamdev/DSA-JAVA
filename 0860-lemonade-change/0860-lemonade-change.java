class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fivecnt=0,tencnt=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5) fivecnt++;
            else if(bills[i]==10){
                fivecnt--;
                tencnt++;
                if(fivecnt<0) return false;
            }
            else{
                if(tencnt>0 && fivecnt>0) {
                    tencnt--;
                    fivecnt--;
                }
                else if(fivecnt>=3){
                    fivecnt-=3;
                }
                else{
                    return false;
                }

            }
        }
        return true;
    }
}