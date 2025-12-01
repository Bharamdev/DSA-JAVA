class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        backtrack(0,s,new StringBuilder());
        return ans;
    }
    void backtrack(int i, String s, StringBuilder str){
        if(i==s.length()){
            ans.add(str.toString());
            return;
        }
        char ch = s.charAt(i);
        if(Character.isLetter(ch)){
            str.append(Character.toLowerCase(ch));
            backtrack(i+1, s, str);
            str.deleteCharAt(str.length()-1);
            str.append(Character.toUpperCase(ch));
            backtrack(i+1, s, str);
            str.deleteCharAt(str.length()-1);
        }
        else{
            str.append(ch);
            backtrack(i+1, s, str);
            str.deleteCharAt(str.length()-1);
        }
    }
}