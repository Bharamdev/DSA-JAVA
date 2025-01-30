class Solution {
    public String largestOddNumber(String num) {
        // StringBuilder str = new StringBuilder();
        // for(int i= 0; i<num.length(); i++){
        //     str.append(num.charAt(i));
        // }
        // for(int i= num.length()-1; i>=0; i--){
        //     if(str.charAt(i)%2==0){
        //         str.deleteCharAt(i);
        //     }
        //     else{
        //         return str.toString();
        //     }
        // }
        // return str.toString();
        int n=num.length();
        for(int i= num.length()-1; i>=0; i--){
            if(num.charAt(i)%2==1){
                return num.substring(0,i+1);
            }
        }
        return "";
        
    }
}