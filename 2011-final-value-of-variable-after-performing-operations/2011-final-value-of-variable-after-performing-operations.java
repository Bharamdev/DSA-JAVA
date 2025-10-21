class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int cnt=0;
        for(String str : operations){
            if(str.charAt(1)=='+') cnt++;
            else cnt--;
        }
        return cnt;
    }
}