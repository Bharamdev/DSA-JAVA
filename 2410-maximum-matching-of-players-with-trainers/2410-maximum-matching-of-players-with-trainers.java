class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int p=players.length;
        int t=trainers.length;
        int match=0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i=0,j=0;
        while(i<p && j<t){
            if(players[i]<=trainers[j]){
                match++;
                i++;
                j++;
            }
            else j++;
        }
        return match;
    }
}