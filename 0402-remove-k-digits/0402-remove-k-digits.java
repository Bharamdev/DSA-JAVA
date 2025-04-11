class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<num.length();i++){
            while(!stack.isEmpty() && k>0 && stack.peek()>num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        } 
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        if(stack.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder();
        for (char digit : stack) {
            sb.append(digit);
        }
        while(sb.length()>0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        if(sb.isEmpty()) return "0";
        return sb.toString();
    }
}