class Solution {
    public int countBinarySubstrings(String s) {
        int curr=1;
        int prev=1;
        int ans=0;
        int n = s.length();
        for(int i=1;i<n;i++){
            if(s.charAt(i-1)==s.charAt(i)) curr++;
            else{
                prev=curr;
                curr=1;
            }
            if(prev>=curr) ans++;
        }
        return ans;
    }
}