class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        // code here
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: arr) map.put(num,map.getOrDefault(num,0)+1);
        // for(int i=0;i<arr.length;i++) arr[i]=freq.get(arr[i]);
        
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        int n=arr.length;
        for(int i=n-1;i>=0;i--){
            int num=arr[i];
            int freq = map.get(num);
            while(!st.isEmpty() && freq>=map.get(st.peek())){
                st.pop();
            }
            
            if(!st.isEmpty()) res.add(st.peek());
            else res.add(-1);
            st.push(num);
        }
        Collections.reverse(res);
        return res;
    }
}