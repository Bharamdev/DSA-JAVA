class Solution {
    public String mergeAlternately(String word1, String word2) {
        int left=0,right=0;
        int m=word1.length(), n=word2.length();
        StringBuilder ans = new StringBuilder();
        while(left<m && right<n){
            ans.append(word1.charAt(left));
            ans.append(word2.charAt(right));
            left++;
            right++;
        }
        while(left<m){
            ans.append(word1.charAt(left));
            left++;
        }
        while(right<n){
            ans.append(word2.charAt(right));
            right++;
        }
        return ans.toString();
    }
}