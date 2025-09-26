class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder str = new StringBuilder(s);
        // int n=part.length();
        // for(char ch: s.toCharArray()){
        //     str.append(ch);
        //     int size = str.length();
        //     if(size>=n){
        //         if(str.substring(size-n).equals(part)) str.delete(size-n,size);
        //     }
        // }
        // return str.toString();
        int len = part.length();
        while(true){
            int index = str.indexOf(part);
            if(index==-1) return str.toString();
            str.delete(index,index+len);
        }
    }
}