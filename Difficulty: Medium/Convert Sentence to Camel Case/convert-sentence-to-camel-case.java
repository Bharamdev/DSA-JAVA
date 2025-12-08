// User function Template for Java

class Solution {
    // Function to convert the given string to Camel Case
    public String convertToCamelCase(String s) {
        // code here
        String[] str = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        sb.append(str[0]);
        for(int i=1;i<str.length;i++){
            String curr = str[i];
            sb.append(Character.toUpperCase(curr.charAt(0)));
            sb.append(curr.substring(1));
        }
        return sb.toString();
    }
}