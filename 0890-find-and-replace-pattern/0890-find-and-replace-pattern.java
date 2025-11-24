class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] p = fn(pattern);
        List<String> ans = new ArrayList<>();
        for(String word: words){
            if(Arrays.equals(p, fn(word))) ans.add(word);
        }
        return ans;
    }
    int[] fn(String s){
        int[] res = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.putIfAbsent(ch, map.size());
            res[i]=map.get(ch);
        }
        return res;
    }
}