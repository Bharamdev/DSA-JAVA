class Solution {
    public int countWays(int[][] ranges) {
        int cnt=1;
        Arrays.sort(ranges,(a,b) -> a[0]-b[0]);
        int[] arr = ranges[0];
        for(int i=0;i<ranges.length;i++){
            if(ranges[i][0]<=arr[1]){
                arr[1]=Math.max(arr[1],ranges[i][1]);
            }
            else{
                cnt++;
                arr[0]=ranges[i][0];
                arr[1]=ranges[i][1];
            }
        }
        int mod = 1_000_000_007;
        return pow(2, cnt, mod);
    }
    public int pow(int base, int expo, int mod){
        long res=1;
        long b = base;
        while(expo>0){
            if(expo%2==1){
                res = (res*b)%mod;
            }
            b = (b*b)%mod;
            expo/=2;
        }
        return (int)res;
    }
}