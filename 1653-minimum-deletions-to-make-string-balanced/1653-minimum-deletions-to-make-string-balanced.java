class Solution {
    public int minimumDeletions(String s) {
       int deletions = 0;
       int bCnt=0;
       for(char ch: s.toCharArray()){
          if(ch=='b') bCnt++;
          else{
            // Delete all previous 'b' or delete current 'a'
            deletions = Math.min(deletions+1, bCnt);  
          }
       }
       return deletions;
    }
}