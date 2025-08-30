class Solution {
    public int getLeastFrequentDigit(int n) {
        int[] freq = new int[10];
        String s = Integer.toString(n);
        for(char ch: s.toCharArray()) freq[ch-'0']++;
        int res=11, minFreq = Integer.MAX_VALUE;
        for(int i=0;i<10;i++){
            if(freq[i]>0){
                if((freq[i]<minFreq) || (freq[i]==minFreq && i<res)){
                    minFreq=freq[i];
                    res=i;
                }
            }
        }
        return res;
    }
}