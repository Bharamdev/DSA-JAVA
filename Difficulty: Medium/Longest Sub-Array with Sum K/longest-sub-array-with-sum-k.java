//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int k = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            int ans =
                ob.lenOfLongestSubarr(nums, k); // Call the function and store result
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int lenOfLongestSubarr(int[] arr, int k) {
        // code here
        Map<Long, Integer> map = new HashMap<>();
        int max = 0;
        long sum=0;
        for(int i=0; i<arr.length;i++){
            sum+=arr[i];
            if(sum==k){
                max = Math.max(max, i+1);
            }
            long rem = sum-k;
            if(map.containsKey(rem)){
               int len = i - map.get(rem);
               max = Math.max(max, len);
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return max;
        
    }
}
