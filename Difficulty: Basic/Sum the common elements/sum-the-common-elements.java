class Geeks {
    public static int commonSum(int n1, int n2, int arr1[], int arr2[]) {
        // Your code here
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int i: arr1) set1.add(i);
        for(int i: arr2) set2.add(i);
        long sum=0, mod=1000000007;
        for(int i: set1){
            if(set2.contains(i)) sum+=i;
        }
        sum=sum%mod;
        return (int)sum;
    }
}