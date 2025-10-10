// User function Template for Java

class Solution {
    String findSum(String s1, String s2) {
        // code here
        int n1 = s1.length();
        int n2 = s2.length();
        String str1 = new StringBuilder(s1).reverse().toString();
        String str2 = new StringBuilder(s2).reverse().toString();
        StringBuilder res = new StringBuilder();
        int carry=0;
        for(int i=0;i<Math.max(n1,n2);i++){
            int digit1=0,digit2=0;
            if(i<n1) digit1 = str1.charAt(i) - '0';
            if(i<n2) digit2 = str2.charAt(i) - '0';
            int sum = digit1+digit2+carry;
            carry = sum/10;
            res.append(sum%10);
        }
        if(carry>0) res.append(carry);
        String result =  res.reverse().toString();
        int i=0;
        while(i<result.length()-1 && result.charAt(i)=='0') i++;
        return result.substring(i);
    }
}