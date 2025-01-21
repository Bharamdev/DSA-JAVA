class Solution {
    public int mySqrt(int x) {
        int start=1, end=x;
        if(x==0) return 0;
        while(start<=end){
            int mid=start + (end-start)/2;
            long sq= (long)mid*mid;
            if(sq==x){
                return mid;
            }
            else if(sq>x){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return end;
    }
}