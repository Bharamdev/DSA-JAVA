class Solution {
    public int maxOperations(String s) {
        int one=0;
        int cnt=0;
        // for(int i=0;i<s.length()-1;i++){
        //     if(s.charAt(i)=='1') one++;
        //     if(s.charAt(i)=='1' && s.charAt(i+1)=='0') cnt+=one;
        // }

        // optimize
        int n = s.length();
        int i=0;
        while(i<n){
            if(s.charAt(i)=='0'){
                while(i+1<n && s.charAt(i+1)=='0') i++;
                cnt+=one;
            }
            else one++;
            i++;
        }
        return cnt;
    }
}