class Solution {
    public static boolean is_possible_to_get_seats(int n, int m, int[] seats) {
        // code here
        if(n==0) return true;
        for(int i=0;i<m;i++){
            if(seats[i]==0){
                boolean left = (i==0) || (seats[i-1]==0);
                boolean right = (i==m-1) || (seats[i+1]==0);
                if(left && right) {
                    seats[i]=1;
                    n--;
                }
                if(n==0) return true;
            }
        }
        return false;
    }
}
