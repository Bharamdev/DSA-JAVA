class Solution {
    public String[] s = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            List<String> curr = new ArrayList<>();
            return curr;
        }
        return help(digits);
    }
    public List<String> help(String digits){
        if(digits.length()==0){
            List<String> curr = new ArrayList<>();
            curr.add("");
            return curr;
        }
        char ch = digits.charAt(0);
        List<String> str = help(digits.substring(1));
        List<String> fstr = new ArrayList<>();
        String s2 = s[ch-'2'];
        for(char chs: s2.toCharArray()){
            for(int i=0;i<str.size();i++){
                String c = str.get(i);
                fstr.add(chs+c);
            }
        }
        return fstr;
    }
}