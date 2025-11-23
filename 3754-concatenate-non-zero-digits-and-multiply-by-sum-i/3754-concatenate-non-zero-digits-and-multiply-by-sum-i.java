class Solution {
    public long sumAndMultiply(int n) {
        long sum=0;
        long num=0;
        long place=1;
        while(n>0){
            int digit = n%10;
            if(digit!=0){
                num = place*digit + num;
                place*=10;
            }
            sum+=digit;
            n/=10;
        }
        return num*sum;
    }
}