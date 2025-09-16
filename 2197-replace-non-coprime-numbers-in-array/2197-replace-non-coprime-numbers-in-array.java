class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> st = new ArrayList<>();
        for(int num: nums){
            st.add(num);
            while(st.size() > 1){
                int a = st.get(st.size()-1);
                int b = st.get(st.size()-2);
                int g = gcd(a,b);
                if(g==1) break;
                long lcm = (long)a/g * b;
                st.remove(st.size()-1);
                st.remove(st.size()-1);
                st.add((int)lcm);
            }
        }
        return st;
    }
    int gcd(int a, int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}