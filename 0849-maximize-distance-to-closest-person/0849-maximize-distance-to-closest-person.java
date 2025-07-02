class Solution {
    public int maxDistToClosest(int[] seats) {
        int maxdis = 0;
        int lastoccupy = -1;
        int n=seats.length;
        for(int i=0;i<n;i++){
            if(seats[i]==1){
                if(lastoccupy==-1) maxdis=i;
                else{
                    int dis = (i-lastoccupy)/2;
                    maxdis = Math.max(maxdis,dis);
                }
                lastoccupy=i;
            }
        }
        maxdis = Math.max(maxdis, n-1-lastoccupy);
        return maxdis;
    }
}