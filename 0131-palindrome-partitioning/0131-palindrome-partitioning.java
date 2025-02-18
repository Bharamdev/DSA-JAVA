class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> arr = new ArrayList<>();
        find(0,s,arr,ans);
        return ans;
    }
    static void find(int index, String s, List<String> arr ,List<List<String>> ans ){
        if(index==s.length()){
            ans.add(new ArrayList<>(arr));
            return;
        }
        for(int i=index; i<s.length(); i++){
            if(palindrome(s, index, i)){
                arr.add(s.substring(index,i+1));
                find(i+1, s, arr, ans);
                arr.remove(arr.size()-1);
            }
        }
    }
    static boolean palindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}