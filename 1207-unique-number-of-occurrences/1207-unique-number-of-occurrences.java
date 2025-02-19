class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            mpp.put(arr[i], mpp.getOrDefault(arr[i],0) + 1 );
        }
        HashSet<Integer> set = new HashSet<>();
        for(int freq: mpp.values()){
            if(!set.add(freq)) return false;
        }
        return true;
    }
}