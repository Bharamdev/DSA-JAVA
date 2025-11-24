class Solution {
    Set<String> set = new HashSet<>();
    Map<String, Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        for(String str: wordDict) set.add(str);
        return  fn(s);
    }
    boolean fn(String s){
        if(s.length()==0) return true;
        if(memo.containsKey(s)) return memo.get(s);
        for(int i=0;i<s.length();i++){
            String pre = s.substring(0,i+1);
            String rest = s.substring(i+1);
            if(set.contains(pre) && fn(rest)){
                memo.put(s,true);
                return true;
            }
        }
        memo.put(s,false);
        return false;
    }
}