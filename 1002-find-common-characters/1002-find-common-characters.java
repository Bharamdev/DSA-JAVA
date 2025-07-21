class Solution {
    public List<String> commonChars(String[] words) {
        int n=words.length;
        List<String> str = new ArrayList<>();
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, 101);
        for(String s: words){
            int[] freq = new int[26];
            for(char ch: s.toCharArray()){
                freq[ch-'a']++;
            }
            for(int i=0;i<26;i++) minfreq[i] = Math.min(minfreq[i],freq[i]);
        }
        for(int i=0;i<26;i++){
                char ch= (char)(i+'a');
                for(int j=0;j<minfreq[i];j++) str.add(String.valueOf(ch));
        }
        return str;
    }
}