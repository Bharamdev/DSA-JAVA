class Solution {
    public int numberOfSubstrings(String s) {
        int ans=0;
        int[] freq = new int[3];
        int n=s.length(),right=0,left=0;
        while(right<n){
            freq[s.charAt(right)-'a']++;
            while(freq[0]>0 && freq[1]>0 && freq[2]>0){
                ans+= n-right;
                freq[s.charAt(left)-'a']--;
                left++;
            }
            right++;
        }
        return ans;
    }
}