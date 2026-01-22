// User function Template for Java

class Solution {
    // Function to find common elements in three arrays.
    public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2,
                                        List<Integer> arr3) {
        // Code Here
        List<Integer> res = new ArrayList<>();
        int n1=arr1.size(), n2=arr2.size(), n3=arr3.size();
        int i=0,j=0,k=0;
        while(i<n1 && j<n2 && k<n3){
            int a=arr1.get(i);
            int b=arr2.get(j);
            int c=arr3.get(k);
            if(a==b && b==c){
                res.add(a);
                while(i<n1 && arr1.get(i)==a) i++;
                while(j<n2 && arr2.get(j)==a) j++;
                while(k<n3 && arr3.get(k)==a) k++;
            }
            else if(a<b) i++;
            else if(b<c) j++;
            else k++;
        }
        if(res.size()==0) res.add(-1);
        return res;
    }
}