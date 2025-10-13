class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> list = new ArrayList<>();
        int n = words.length;
        for(String word: words){
            if(!list.isEmpty() && !isAnagram(list.get(list.size()-1),word)){
                list.add(word);
            }
            else if(list.isEmpty()){
                list.add(word);
            }
        }
        return list;
    }
    boolean isAnagram(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1 != n2) return false;
        int[] f = new int[26];
        for(int i=0;i<s1.length();i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            f[ch1-'a']++;
            f[ch2-'a']--;
        }
        for(int i : f){
            if(i!=0) return false;
        }
        return true;
    }
}