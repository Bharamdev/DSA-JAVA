class Solution {
    public int countOdds(int low, int high) {
        int numbers=high-low+1;
        int cnt=numbers/2;
        return (low%2==1 && numbers%2==1) ? cnt+1 : cnt;
    }
}