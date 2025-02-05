class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int cnt=0;
        int[] arr = new int[2];
        if(s1.equals(s2)) return true;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i) ){
                if(cnt==2) return false;
                arr[cnt++]=i;
            }
            
        }
        if(cnt==2) {
            int i=arr[0];
            int j = arr[1];
            return s1.charAt(i)==s2.charAt(j) && s1.charAt(j)==s2.charAt(i);
        };
        return false;
    }
}