class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String[] builder =  s.split("\\s+");
        
       
        StringBuilder ans = new StringBuilder();
        for(int i=builder.length-1; i>=0; i--){
            ans.append(builder[i]);
            if(i>0){
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}