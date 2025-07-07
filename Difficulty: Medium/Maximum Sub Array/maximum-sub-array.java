// User function Template for Java

class Solution {
    public ArrayList<Integer> findSubarray(int arr[]) {
        // code here
        int n=arr.length;
        int sum=0,maxSum=-1,tempStart=0,start=0,end=0;
        for(int i=0;i<n;i++){
            if(arr[i]>=0){
                sum+=arr[i];
                if(sum>maxSum || (sum==maxSum && tempStart<=start)){
                    maxSum=sum;
                    start=tempStart;
                    end=i;
                }
            }
            else{
                sum=0;
                tempStart=i+1;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if(maxSum==-1){
            ans.add(-1);
            return ans;
        }
        for(int i=start;i<=end;i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}