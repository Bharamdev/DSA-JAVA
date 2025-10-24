class Solution {

    public boolean isPossible(int[] arr, int k) {
        // Code here
        Map<Integer,Integer> freq = new HashMap<>();
        Map<Integer,Integer> end = new HashMap<>();
        for(int a: arr) freq.put(a, freq.getOrDefault(a,0)+1);
        Arrays.sort(arr);
        for(int num: arr){
            if(freq.get(num)==0) continue;
            if(end.getOrDefault(num-1,0) > 0){
                end.put(num-1,end.get(num-1)-1);
                end.put(num, end.getOrDefault(num,0)+1);
                freq.put(num, freq.get(num)-1);
            }
            else{
                for(int i=0;i<k;i++){
                    if(freq.getOrDefault(num+i,0)<=0) return false;
                    freq.put(num+i,freq.get(num+i)-1);
                }
                end.put(num+k-1, end.getOrDefault(num+k-1,0)+1);
            }
        }
        return true;
    }
}