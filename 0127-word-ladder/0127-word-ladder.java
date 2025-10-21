class Solution {
    class pair{
        String str;
        int step;
        pair(String str, int step){
            this.str = str;
            this.step = step;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String s: wordList) set.add(s);
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(beginWord,1));
        while(!q.isEmpty()){
            String word = q.peek().str;
            int step = q.poll().step;
            if(word.equals(endWord)) return step;
            for(int i=0;i<word.length();i++){
                for(char ch='a'; ch<='z';ch++){
                    char[] arr = word.toCharArray();
                    arr[i]=ch;
                    String replace = new String(arr);
                    if(set.contains(replace)){
                        q.offer(new pair(replace,step+1));
                        set.remove(replace);
                    }
                }
            }
        }
        return 0;
    }
}