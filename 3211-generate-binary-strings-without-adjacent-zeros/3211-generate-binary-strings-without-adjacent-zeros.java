class Solution {
    List<String> res = new ArrayList<>();
    public List<String> validStrings(int n) {
        backTrack(0, n, new StringBuilder());
        return res;
    }
    void backTrack(int idx, int n, StringBuilder str){
        if(idx==n){
            if(isValid(str.toString())) res.add(str.toString());
            return;
        }
        // Take '0'
        str.append('0');
        backTrack(idx+1, n, str);
        str.deleteCharAt(str.length()-1);
        // Take '1'
        str.append('1');
        backTrack(idx+1, n, str);
        str.deleteCharAt(str.length()-1);
    }
    boolean isValid(String str){
        int size = str.length();
        for(int i=1;i<size;i++){
            if(str.charAt(i)=='0' && str.charAt(i-1)=='0') return false;
        }
        return true;
    }
}