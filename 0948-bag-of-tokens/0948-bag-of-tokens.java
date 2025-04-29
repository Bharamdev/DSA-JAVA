class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score=0;
        int n=tokens.length;
        int i=0,j = n-1;
        Arrays.sort(tokens);
        int maxScore=0;
        while(i<=j){
            if(power>=tokens[i]){
                power-=tokens[i++];
                score++;
                maxScore = Math.max(maxScore,score);
            }
            else if(score>0){
                power+=tokens[j--];
                score--;
            }
            else{
                break;
            }
        }
        return maxScore;
    }
}