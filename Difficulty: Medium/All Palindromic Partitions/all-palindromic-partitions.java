class Solution {
    ArrayList<ArrayList<String>> ans = new ArrayList<>();
    public ArrayList<ArrayList<String>> palinParts(String s) {
        // code here
        ArrayList<String> str = new ArrayList<>();
        solution(s,str);
        return ans;
    }
    void solution(String s, ArrayList<String> str){
        if(s.length()==0){
            ans.add(new ArrayList<>(str));
            return;
        }
        for(int i=0;i<s.length();i++){
            String pre = s.substring(0,i+1);
            String post = s.substring(i+1);
            if(isPalindrome(pre,0,i)){
                str.add(pre);
                solution(post, str);
                str.remove(str.size()-1);
            }
        }
    }
    boolean isPalindrome(String pre, int s, int e){
        while(s<e){
            if(pre.charAt(s)!=pre.charAt(e)) return false;
            s++;
            e--;
        }
        return true;
    }
}
