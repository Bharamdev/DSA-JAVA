class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt=0;
        for(int num: arr){
            if(num%2==1) cnt++;
            else cnt=0;
            if(cnt==3) return true;
        }
        return cnt==3;
    }
}