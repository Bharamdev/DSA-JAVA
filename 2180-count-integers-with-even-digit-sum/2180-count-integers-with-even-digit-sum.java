class Solution {
    public int countEven(int num) {
       int count=0;
       for(int i=1; i<=num; i++){
        if(Even(i)) count++;
       }
       return count;
    }
    public static boolean Even(int n){
        int sum=0;
        while(n>0){
            int digit = n%10;
            sum+=digit;
            n=n/10;
        }
        if(sum%2==0){
            return true;
        }
        else{
            return false;
        }
    }
}