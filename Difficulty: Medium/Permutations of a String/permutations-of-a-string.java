class Solution {
    ArrayList<String> ans = new ArrayList<>();
    int n;
    boolean[] vis;
    public ArrayList<String> findPermutation(String s) {
        // Code here
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        s = new String(arr);
        n=s.length();
        vis = new boolean[n];
        StringBuilder str = new StringBuilder();
        permutations(0,s,str);
        return ans;
    }
    void permutations(int idx, String s, StringBuilder str){
        if(idx==s.length()){
            ans.add(str.toString());    
            return;
        }
        for(int i=0;i<n;i++){
            if(i>0 && s.charAt(i)==s.charAt(i-1) && !vis[i-1]) continue;
            if(!vis[i]){
                vis[i]=true;
                str.append(s.charAt(i));
                permutations(idx+1, s, str);
                vis[i]=false;
                str.deleteCharAt(str.length()-1);
            }
        }
    }
}