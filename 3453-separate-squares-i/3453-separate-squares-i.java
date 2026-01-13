class Solution {
    public double separateSquares(int[][] squares) {
        double area = 0;
        double low=Integer.MAX_VALUE, high=Integer.MIN_VALUE;
        for(int[] s: squares){
            int y = s[1];
            int l = s[2];
            area += (1.0*l*l);
            low = Math.min(low, y);
            high = Math.max(high, y+l);
        }
        double res=0;
        while(high-low > 1e-5){
            double mid = low + (high-low)/2;
            res = mid;
            if(check(squares, mid, area)){
                high = mid;
            }
            else low = mid;
        }
        return res;
    }
    boolean check(int[][] squares, double mid, double area){
        double botArea = 0;
        for(int[] s: squares){
            int y=s[1], l=s[2];
            int boty=y, topy=y+l;
            if(mid>=topy) botArea += (1.0*l*l);
            else if(mid>boty) botArea += (1.0*l*(mid-boty));
        }
        return botArea >= area/2;
    }
}