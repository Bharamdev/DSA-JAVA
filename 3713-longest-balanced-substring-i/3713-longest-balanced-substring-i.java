    class Solution {
        public int longestBalanced(String s) {
            int n = s.length();
            int maxi=0;
            for(int i=0;i<n;i++){
                int[] freq = new int[26];
                for(int j=i;j<n;j++){
                    freq[s.charAt(j)-'a']++;
                    if(isBalanced(freq)){
                        int len = j-i+1;
                        maxi = Math.max(maxi, len);
                    }
                }
            }
            return maxi;
        }
        boolean isBalanced(int[] freq){
            int first=0;
            for(int f: freq){
                if(f>0){
                    if(first==0) first=f;
                    else if(f != first) return false;
                } 
            }
            return true;
        }
    }