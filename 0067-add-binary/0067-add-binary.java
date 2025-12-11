class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int n=a.length(), m=b.length();
        int i=n-1, j=m-1, carry=0;
        while(i>=0 || j>=0 || carry==1){
            int sum=carry;
            if(i>=0) sum+= a.charAt(i--)-'0';
            if(j>=0) sum+= b.charAt(j--)-'0';
            sb.append(sum%2);
            carry = sum/2;
        }
        return sb.reverse().toString();
    }
}