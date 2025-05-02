//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findSubString(String str) {
        // code here
        HashSet<Character> set = new HashSet<>();
        for(char ch: str.toCharArray()){
            set.add(ch);
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int cnt=0,minLen=Integer.MAX_VALUE,start=0;
        for(int i=0;i<str.length();i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
            if(map.get(str.charAt(i))==1) cnt++;
            
            while(cnt==set.size()){
                minLen = Math.min(minLen,i-start+1);
                map.put(str.charAt(start),map.get(str.charAt(start))-1);
                
                if(map.get(str.charAt(start))==0) cnt--;
                
                start++;
            }
            
        }
        return minLen;
        
    }
}