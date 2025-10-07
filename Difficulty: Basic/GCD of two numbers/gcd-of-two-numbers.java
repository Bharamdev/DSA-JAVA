class Solution {
    public static int gcd(int a, int b) {
        // code herei
        int rem=1;
        while(rem!=0){
            rem = a%b;
            a=b;
            b=rem;
        }
        return a;
    }
}
