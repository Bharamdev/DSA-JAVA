class Solution {
    public long maxRunTime(int n, int[] batteries) {
        int len=batteries.length;
        if(len<n) return 0;
        long totalEnergy=0;
        for(int x: batteries) totalEnergy += x;
        Arrays.sort(batteries);
        for(int i=len-1;i>=0;i--){
            if(batteries[i] > totalEnergy/n){
                totalEnergy -= batteries[i];
                n--;
            }
            else break;
        }
        return totalEnergy/n;
    }
}