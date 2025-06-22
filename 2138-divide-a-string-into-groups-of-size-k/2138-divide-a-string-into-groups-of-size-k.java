class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> ans = new ArrayList<>();
        for(int i=0;i<s.length();i+=k){
            StringBuilder str = new StringBuilder();
            for(int j=i;j<i+k;j++){
                if(j<s.length()) str.append(s.charAt(j));
                else str.append(fill);
            }
            ans.add(str.toString());
        }
        return ans.toArray(new String[0]);
    }
}