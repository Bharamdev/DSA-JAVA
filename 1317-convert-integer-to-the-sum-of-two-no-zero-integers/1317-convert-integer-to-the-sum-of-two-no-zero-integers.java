class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i=1;i<=n;i++){
            int j = n-i;
            if(isValid(i) && isValid(j)) return new int[]{i,j};
        }
        return new int[]{};
    }
    public boolean isValid(int num){
        while(num>0){
            int digit=num%10;
            if(digit==0) return false;
            num/=10;
        }
        return true;
    }
}