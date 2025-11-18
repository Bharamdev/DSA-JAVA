class Solution {
    List<Character> list;
    int[] map = new int[26];
    boolean[] used = new boolean[10];
    public boolean isSolvable(String[] words, String result) {
        Set<Character> set = new HashSet<>();
        for(String w: words)
          for(char ch: w.toCharArray()) set.add(ch);
        for(char ch: result.toCharArray()) set.add(ch);
        list = new ArrayList<>(set);
        return fn(0,words,result);   
    }
    boolean fn(int idx, String[] words, String result){
        if(idx==list.size()) return check(words, result);
        char ch = list.get(idx);
        for(int d=0; d<=9; d++){
            if(used[d]) continue;
            used[d]=true;
            map[ch-'A']=d;
            if(fn(idx+1, words, result)) return true;
            used[d]=false;
        }
        return false;
    }
    boolean check(String[] words, String result){
        int sum=0;
        for(String w: words){
            if(map[w.charAt(0)-'A']==0 && w.length()>1) return false;
            sum+=convert(w);
        }
        if(map[result.charAt(0)-'A']==0 && result.length()>1) return false;
        return sum == convert(result);
    }
    int convert(String word){
        int num=0;
        for(char ch: word.toCharArray()){
            num = num*10 + map[ch-'A'];
        }
        return num;
    }
}