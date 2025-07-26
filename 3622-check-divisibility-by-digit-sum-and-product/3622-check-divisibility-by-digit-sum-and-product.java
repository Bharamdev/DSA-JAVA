class Solution {
    public boolean checkDivisibility(int n) {
        long sum=0,pro=1;
        int og=n;
        while(n>0){
            int digit = n%10;
            sum+=(long)digit;
            pro*=(long)digit;
            n/=10;
        }
        return og%(sum+pro)==0 ? true : false;
    }
}