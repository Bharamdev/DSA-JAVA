class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(); 
        List<Integer> ds= new ArrayList<>();
        for(int i=1; i<=numRows; i++){
            ds = pascal(i);
            ans.add(ds);
        }
        return ans;
    }
    public static List<Integer> pascal(int num){
        List<Integer> ansRow = new ArrayList<>();
        int ans=1;
        ansRow.add(1);
        for(int i=1; i<num; i++){
            ans = ans*(num-i);
            ans = ans/i;
            ansRow.add(ans);
        }
        return ansRow;
    }
}