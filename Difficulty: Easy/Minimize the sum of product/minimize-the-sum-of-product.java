//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;


// } Driver Code Ends

// User function Template for Java

class Solution {
    public long minValue(List<Integer> arr1, List<Integer> arr2) {
        // code here
        long sum=0;
        Collections.sort(arr1);
        Collections.sort(arr2);
        for(int i=0;i<arr1.size();i++){
            int multiple = arr1.get(i)*arr2.get(arr2.size()-1-i);
            sum+=multiple;
        }
        return sum;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr1 = new ArrayList<>();
            List<Integer> arr2 = new ArrayList<>();

            String input1 = sc.nextLine();
            StringTokenizer st1 = new StringTokenizer(input1);
            while (st1.hasMoreTokens()) {
                arr1.add(Integer.parseInt(st1.nextToken()));
            }

            String input2 = sc.nextLine();
            StringTokenizer st2 = new StringTokenizer(input2);
            while (st2.hasMoreTokens()) {
                arr2.add(Integer.parseInt(st2.nextToken()));
            }

            Solution ob = new Solution();
            long ans = ob.minValue(arr1, arr2);
            System.out.println(ans);
        
System.out.println("~");
}
        sc.close();
    }
}

// } Driver Code Ends