class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int cnt0 = 0, cnt1 = 0;
        for(int i: students){
            if(i==0) cnt0++;
            else cnt1++;
        }
        for(int i: sandwiches){
            if(i==0){
                if(cnt0 == 0) break;
                cnt0--;
            }
            else{
                if(cnt1== 0) break;
                cnt1--; 
            }
        }
        return cnt0 + cnt1;
    }
}