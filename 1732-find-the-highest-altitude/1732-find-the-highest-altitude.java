class Solution {
    public int largestAltitude(int[] gain) {
        int sum=0, maxi=Integer.MIN_VALUE;
        for(int i=0; i<gain.length; i++){
            sum+=gain[i];
            maxi= Math.max(maxi,sum);
        }
        if(maxi<0) return 0;
        return maxi;
    }
}