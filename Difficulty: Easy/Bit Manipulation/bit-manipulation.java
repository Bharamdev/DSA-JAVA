// User function Template for Java

class Solution {
    static void bitManipulation(int num, int i) {
        // code here
        i=i-1;
        long get = (num>>i)&1;
        long set = num | (1<<i);
        long clear = num & ~(1<<i);
        System.out.print((int)get+" ");
        System.out.print((int)set+" ");
        System.out.print((int)clear);
    }
}
