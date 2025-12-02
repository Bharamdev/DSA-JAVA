class Solution {
    public int countTrapezoids(int[][] points) {
        Map<Integer,Integer> map = new HashMap<>();
        // Count points on each y-level
        for(int[] p: points){
            map.put(p[1], map.getOrDefault(p[1],0)+1);
        }
        long mod = 1000000007;
        long ans=0;
        long sum=0;
        for(int val: map.values()){
            long seg = (long)val * (val-1)/2;  // No. of horizontal segments
            ans = (ans + sum*seg)%mod;
            sum = (sum + seg)%mod;
        }
        return (int)ans;
    }
}