class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder str = new StringBuilder();
        int n=part.length();
        for(char ch: s.toCharArray()){
            str.append(ch);
            int size = str.length();
            if(size>=n){
                if(str.substring(size-n).equals(part)) str.delete(size-n,size);
            }
        }
        return str.toString();
    }
}