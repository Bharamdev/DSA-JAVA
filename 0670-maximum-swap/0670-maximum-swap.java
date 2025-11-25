class Solution {
    public int maximumSwap(int num) {
        String s = Integer.toString(num);
        int n=s.length();
        for(int i=0;i<n-1;i++){
            char maxDigit = s.charAt(i);
            for(int j=i+1; j<n;j++){
                if(s.charAt(j)>maxDigit) maxDigit=s.charAt(j);
            }
            for(int j=n-1;j>i;j--){
                    if(s.charAt(j)==maxDigit && s.charAt(i)!=maxDigit){
                        s = swap(s,i,j);
                        return Integer.parseInt(s);
                    }
                }
        }
        return num;
    }
    String swap(String s, int i, int j){
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}