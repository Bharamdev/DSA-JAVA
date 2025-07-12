class Solution {
    public int maxDepth(String s) {
        int max=0;
        int open=0;
        for(char ch: s.toCharArray()){
            if(ch=='(') open++;
            else if(ch==')') open--;
            max = Math.max(max,open);
        }
        return max;
    }
}