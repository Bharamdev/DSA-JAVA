class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int n=num1.length(),m=num2.length();
        int[] arr = new int[m+n];
        for(int i=n-1;i>=0;i--){
            int digit1 = num1.charAt(i)-'0';
            for(int j=m-1;j>=0;j--){
                int digit2= num2.charAt(j)-'0';
                int product = digit1*digit2;
                int sum= product + arr[i+j+1];
                arr[i+j+1] = sum%10;
                arr[i+j]+=sum/10;
            }
        }
        StringBuilder str = new StringBuilder();
        for(int num: arr){
            if(str.length()==0 && num==0) continue;
            str.append(num);
        }
        return str.toString();
    }
}