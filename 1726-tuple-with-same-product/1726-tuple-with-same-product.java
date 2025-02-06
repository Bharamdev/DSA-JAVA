class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> product = new HashMap<>(); 
        int cnt;
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
            int multiple = nums[i] * nums[j];
            product.put(multiple, product.getOrDefault(multiple,0) + 1 );
        }
        }
        int ans=0;
        for(int count: product.values()){
            if(count>1){
            ans += ((count*(count-1))/2)*8;
            }
        }
        return ans;
    }
}