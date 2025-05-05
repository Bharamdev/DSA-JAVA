class Solution {
    public boolean isBalanced(String num) {
        int sum=0;
        for(int i=0;i<num.length();i++){
            if(i%2==0){
                sum+=(num.charAt(i)-'0');
            }
            else sum-=(num.charAt(i)-'0');
        }
        return sum==0;
    }
}