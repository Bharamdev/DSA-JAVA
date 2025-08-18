class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n=skill.length;
        int l=0,r=n-1;
        long res=0;
        int sum= skill[l]+skill[r];
        while(l<=r){
            if(skill[l]+skill[r] != sum) return -1;
            res+= (skill[l]*skill[r]);
            l++;
            r--;
        }
        return res;
    }
}