class Solution {
    Map<String, List<Character>> map = new HashMap<>();
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for(String str: allowed){
            String key = str.substring(0,2);
            char top = str.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(top);
        }
        return dfs(bottom);
    }
    boolean dfs(String bottom){
        if(bottom.length() == 1) return true;
        List<String> nextRows = new ArrayList<>();
        buildNextRow(bottom, 0, new StringBuilder(), nextRows);
        for(String next: nextRows){
            if(dfs(next)) return true;
        }
        return false;
    }
    void buildNextRow(String bottom, int idx, StringBuilder curr, List<String> nextRows){
        if(idx==bottom.length()-1){
            nextRows.add(curr.toString());
            return;
        }
        String key = bottom.substring(idx,idx+2);
        if(!map.containsKey(key)) return;
        for(char ch: map.get(key)){
            curr.append(ch);
            buildNextRow(bottom, idx+1, curr, nextRows);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}