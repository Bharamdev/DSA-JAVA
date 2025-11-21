// User function Template for Java

class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> all_palindromes(String s) {
        // Code here
        Map<Character,Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        int len=0;
        int odds=0;
        Character odd=null;
        for(char key: map.keySet()){
            int f = map.get(key);
            if(f%2==1){
                odds++;
                odd=key;
            }
            map.put(key,f/2);
            len+=f/2;
        }
        if(odds>1) return ans;
        generate(1,len,map,odd,"");
        return ans;
    }
    void generate(int index, int len, Map<Character,Integer> map,
                  Character odd, String str){
        if(index>len){
            String res=str;;
            String rev = new StringBuilder(str).reverse().toString();
            if(odd!=null) res+=odd;
            res+=rev;
            ans.add(res);
            return;
        }  
        List<Character> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for(char ch: keys){
            int freq = map.get(ch);
            if(freq>0){
                map.put(ch,freq-1);
                generate(index+1,len,map,odd,str+ch);
                map.put(ch,freq);
            }
        }             
    }
}
