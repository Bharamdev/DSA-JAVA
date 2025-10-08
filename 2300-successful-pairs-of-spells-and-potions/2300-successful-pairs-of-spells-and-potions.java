class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = potions.length;
        int[] ans = new int[spells.length];
        // Arrays.sort(spells);
        Arrays.sort(potions);
        for(int i=0;i<spells.length;i++){
            long required = (success+spells[i]-1)/spells[i];
            int index = bs(potions, required);
            ans[i] = n-index;
        }
        return ans;
    }
    int bs(int[] potions, long target){
        int l=0,r=potions.length;
        while(l<r){
            int mid = l + (r-l)/2;
            if(potions[mid]<target)  l=mid+1;
            else r=mid; 
        }
        return l;
    }
}