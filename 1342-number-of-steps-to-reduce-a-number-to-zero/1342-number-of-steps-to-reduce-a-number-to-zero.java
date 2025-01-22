class Solution {
    public int numberOfSteps(int num) {
        int count= ans(num, 0);
        return count;
    }
    static int ans(int num, int cnt){
        if(num==0){
            return cnt;
        }
        if(num%2==0){
            return ans(num/2, cnt+1);
        }
        return ans(num-1, cnt+1);
    }
}