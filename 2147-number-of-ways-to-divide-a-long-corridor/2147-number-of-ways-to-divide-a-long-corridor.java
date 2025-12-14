class Solution {
    public int numberOfWays(String corridor) {
        int mod = 1000_000_007;
        int seats=0;
        for(char ch: corridor.toCharArray()){
            if(ch=='S') seats++;
        }
        if(seats%2!=0 || seats<2) return 0;
        long res=1;
        int seat=0,plant=0;
        for(char ch: corridor.toCharArray()){
            if(ch=='S'){
                if(seat==2){
                    seat=0;
                    res = (res * (plant+1))%mod;
                    plant=0;
                }
                seat++;
            }
            else if(ch=='P' && seat==2) plant++;
        }
        return (int)res;
    }
}