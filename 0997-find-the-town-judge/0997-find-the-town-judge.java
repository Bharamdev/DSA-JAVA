class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] outdegree = new int[n+1];
        int[] indegree = new int[n+1];
        for(int[] t: trust){
            outdegree[t[0]]++;
            indegree[t[1]]++;
        }
        for(int i=1;i<=n;i++){
            if(outdegree[i]==0 && indegree[i]==n-1) return i;
        }
        return -1;
    }
}