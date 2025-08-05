class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(baskets[j]>=fruits[i] && !visited[j]){
                    visited[j]=true;
                    break;
                }
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(!visited[i]) cnt++;
        }
        return cnt;
    }
}