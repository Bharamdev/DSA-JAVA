class Solution {
    public int maxVowels(String s, int k) {
        int max=0, i=0,j=0,cnt=0;;
        while(i<s.length() && j<s.length()){
            if(j-i<k){
                if(s.charAt(j)=='a' || s.charAt(j)=='e' || s.charAt(j)=='i' 
                 || s.charAt(j)=='o' || s.charAt(j)=='u'){
                    cnt++;
                }
                j++;
                max= Math.max(max,cnt);
            }
            else{
                if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' 
                 || s.charAt(i)=='o' || s.charAt(i)=='u'){
                    cnt--;
            }
                i++;
            }

        }
        return max;
    }
}