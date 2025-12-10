class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];
        for(int[] e: edges){
            indegree[e[1]]++;
        }
        int champ=-1;
        for(int i=0;i<n;i++){
            if(indegree[i]==0 && champ==-1) champ=i;
            else if(indegree[i]==0 && champ!=-1) return -1;
        }
        return champ;
    }
}