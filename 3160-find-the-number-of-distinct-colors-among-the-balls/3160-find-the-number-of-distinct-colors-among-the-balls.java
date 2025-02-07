import java.util.HashMap;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> mp1 = new HashMap<>(); // Key-to-value map
        HashMap<Integer, Integer> mp2 = new HashMap<>(); // Value frequency map
        
        int[] ans = new int[queries.length]; // Store results
        int i = 0;

        for (int[] query : queries) {
            int key = query[0], value = query[1];

            // If key already exists
            if (mp1.containsKey(key)) { 
                // Get previous value
                int oldValue = mp1.get(key);

                // Decrease frequency of the old value
                if (mp2.get(oldValue) == 1) {
                    mp2.remove(oldValue);
                } else {
                    mp2.put(oldValue, mp2.get(oldValue) - 1);
                }
            }

            // Update new value in mp1
            mp1.put(key, value);

            // Increase frequency of new value in mp2
            mp2.put(value, mp2.getOrDefault(value, 0) + 1);

            // Store the unique value count in answer
            ans[i++] = mp2.size();
        }

        return ans;
    }
}
