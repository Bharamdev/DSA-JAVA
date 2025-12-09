class Solution {
    String[] str = {"","","abc","def","ghi","jkl","mno",
                    "pqrs","tuv","wxyz"};
    ArrayList<String> ans = new ArrayList<>();
    public ArrayList<String> possibleWords(int[] arr) {
        // code here
        backtrack(0,arr,new StringBuilder());
        return ans;
    }
    void backtrack(int idx, int[] arr, StringBuilder sb){
        if(idx==arr.length){
            ans.add(sb.toString());
            return;
        }
        String s = str[arr[idx]];
        if(s.length()==0){
            backtrack(idx+1,arr,sb);
            return;
        }
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            backtrack(idx+1,arr,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}