class Solution {
    List<Integer> ans;
    public List<Integer> lexicalOrder(int n) {
        ans = new ArrayList<>();
        for(int i=1;i<=9;i++){
            fn(i,n);
        }
        return ans;
    }
    void fn(int i, int n){
        if(i>n) return;
        ans.add(i);
        for(int j=0;j<=9;j++){
            fn(i*10 + j, n);
        }
    }
}