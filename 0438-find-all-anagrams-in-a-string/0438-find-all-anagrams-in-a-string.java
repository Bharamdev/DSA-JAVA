class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n=s.length(),size=p.length();
        int r=0,l=0;
        List<Integer> ans = new ArrayList<>();
        int[] arrp = new int[26];
        int[] arrs = new int[26];
        for(char c: p.toCharArray()) arrp[c-'a']++;
        while(r<n){
            char c= s.charAt(r);
            arrs[c-'a']++;
            if(r-l+1>size) {
                arrs[s.charAt(l)-'a']--;
                l++;
            }
            if(Arrays.equals(arrs,arrp)) ans.add(l);
            r++;
        }
        return ans;
        
    }
}