class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int cnt=0;
        for(int i=low;i<=high;i++){
            String str = Integer.toString(i);
            if(str.length()%2==0){
                int mid = str.length()/2;
                int sum1=0,sum2=0;
                for(int j=0;j<mid;j++) sum1+=str.charAt(j);
                for(int j=mid;j<str.length();j++) sum2+=str.charAt(j);
                if(sum1==sum2) cnt++;
            }
        }
        return cnt;
    }
}