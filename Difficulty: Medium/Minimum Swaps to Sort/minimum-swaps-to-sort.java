//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends



class Solution {
    public void swap(int[] arr, int i,int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    // Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int arr[]) {
        // Code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int index=0;
        for(int num:arr){
            map.put(num,index++);
        }
        Arrays.sort(arr);
        int cnt=0;
        int i=0;
          while(i < arr.length){
            if(i != map.get(arr[i])){
                cnt++;
                swap(arr,i,map.get(arr[i]));
            }else{
                i++;
            }
        }
        return cnt;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int ans = obj.minSwaps(arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends