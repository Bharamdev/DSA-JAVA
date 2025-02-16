class Solution {
    public String getPermutation(int n, int k) {
        int product=1;
        List<Integer> arr = new ArrayList<>();
        String ans = "";
        for(int i=1; i<n;i++){
            product*=i;
            arr.add(i);
        }
        arr.add(n);
        k = k-1;
        while(true){
            ans = ans + arr.get(k/product);
            arr.remove(k/product);
            if(arr.size()==0) break;
            k = k % product;
            product=product/arr.size();
        }
        return ans;
    }
}