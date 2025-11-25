

class Solution {
    // Function to find the largest number after k swaps.
    String max="";
    public String findMaximumNum(String s, int k) {
        // code here.
        fn(s, k);
        return max;
    }
    void fn(String s, int k){
        if(s.compareTo(max) > 0) max = s;
        if(k==0) return;
        for(int i=0;i<s.length()-1;i++){
            for(int j=i+1; j<s.length();j++){
                if(s.charAt(j) > s.charAt(i)){
                    String swapped = swap(s, i, j);
                    fn(swapped, k-1);
                }
            }
        }
    }
    String swap(String s, int i, int j){
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}