class Solution {
    public String reverseWords(String s) {
        // Code here
        String[] arr = s.split("\\.");
        StringBuilder str = new StringBuilder();
        int n = arr.length;
        for(int i=n-1;i>=0;i--){
            String ss=arr[i];
            if(!ss.isEmpty()){
               if(str.length()>0) str.append(".");
                str.append(arr[i]);
            }
        }
        return str.toString();
    }
}
