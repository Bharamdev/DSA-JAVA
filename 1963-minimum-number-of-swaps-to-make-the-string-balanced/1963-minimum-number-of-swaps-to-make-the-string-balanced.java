class Solution {
    public int minSwaps(String s) {
        int swap=0;
        int n= s.length();
        int j=n-1;
        int i=0;
        int open=0,close=0;
        while(i<=j){
            if(s.charAt(i)=='[') open++;
            else{
                if(open>0) open--;
                else close++;
            }
            if(close>open){
                if(s.charAt(j)=='['){
                    close--;
                    open++;
                    swap++;
                    j--;
                }
            }
            i++;
        }
        return swap;
    }
}