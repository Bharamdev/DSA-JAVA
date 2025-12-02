// User function Template for Java

class Solution {
    public int unvisitedLeaves(int N, int leaves, int frogs[]) {
        // Code here
        int cnt=0;
        boolean[] vis = new boolean[leaves+1];
        for(int i=0;i<N;i++){
            if(frogs[i]>leaves) continue;
            if(vis[frogs[i]]) continue;
            for(int j=frogs[i]; j<=leaves; j+=frogs[i]){
                vis[j]=true;
            }
        }
        for(int i=1;i<=leaves;i++){
            if(!vis[i]) cnt++;
        }
        return cnt;
    }
}
