class Solution {
    public int minMaxDifference(int num) {
        String str = Integer.toString(num);
        char[] maxarr = str.toCharArray();
        char[] minarr = str.toCharArray();
        char replacemax=' ';
        for(char ch: maxarr){
            if(ch!='9'){
                replacemax=ch;
                break;
            }
        }
        for(int i=0;i<maxarr.length;i++){
            if(maxarr[i]==replacemax){
                maxarr[i]='9';
            }
        }
        char replacemin = minarr[0];
        for(int i=0;i<minarr.length;i++){
            if(minarr[i]==replacemin){
                minarr[i]='0';
            }
        }
        int max = Integer.parseInt(new String(maxarr));
        int min = Integer.parseInt(new String(minarr));
        return max-min;
    }
}