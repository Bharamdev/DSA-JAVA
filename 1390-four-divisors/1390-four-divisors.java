class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum=0;
        for(int num: nums){
            if(num>5) sum+=solve(num);
        }
        return sum;
    }
    int solve(int num){
        int sum=0;
        int cnt=0;
        for(int i=1;i*i<=num;i++){
            if(num%i==0) {
                int d1 = i, d2 = num/i;
                if(d1==d2){
                    sum+=d1;
                    cnt++;
                }
                else{
                    cnt+=2;
                    sum+=d1+d2;
                }
            }
            if(cnt>4) return 0;
        }
        return cnt==4 ? sum : 0;
    }
}