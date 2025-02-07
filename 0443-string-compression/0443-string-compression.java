class Solution {
    public int compress(char[] chars) {
        int left=0, i=0;
        if(chars.length<2) return chars.length;
        while(i<chars.length){
            int cnt=0;
            char currentchar = chars[i];
            while(i<chars.length && currentchar==chars[i]){
                cnt++;
                i++;
            }
            chars[left++]=currentchar;
            if(cnt>1){
                for(char c: Integer.toString(cnt).toCharArray()){
                    chars[left++]=c;
                }
            }
        }
        return left;
    }
}