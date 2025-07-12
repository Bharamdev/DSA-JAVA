class Solution {
    public boolean checkValidString(String s) {
        int minopen=0,maxopen=0;
        int required=0;
        for(char ch: s.toCharArray()){
            if(ch=='('){
                minopen++;
                maxopen++;
            }
            else if(ch==')'){
                minopen--;
                maxopen--;
            }
            else if(ch=='*'){
                minopen--;
                maxopen++;
            }
            minopen=Math.max(minopen,0);
            if(maxopen<0) return false;
        }
        return minopen==0;
    }
}