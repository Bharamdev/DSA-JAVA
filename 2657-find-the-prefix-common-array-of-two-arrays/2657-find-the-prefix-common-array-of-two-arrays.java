class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashMap<Integer, Integer> arr = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int cnt=0;
        for(int i=0; i<A.length; i++){
            arr.put(A[i], arr.getOrDefault(A[i], 0) + 1);
            arr.put(B[i], arr.getOrDefault(B[i], 0) + 1);

            if(A[i]!=B[i]){
                if(arr.get(A[i])>1) cnt++;
                if(arr.get(B[i])>1) cnt++;
            } else{
                cnt++;
            }

            ans.add(cnt);
        }
        int[] result = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            result[i] = ans.get(i);
        }
        
        return result;
    }
}