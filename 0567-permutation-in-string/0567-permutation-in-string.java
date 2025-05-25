class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Size = s1.length();
        int s2Size = s2.length();
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        if(s1Size>s2Size) return false;
        for(int i=0;i<s1Size;i++){
            arr1[s1.charAt(i)-'a']++;
            arr2[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<=s2Size-s1Size;i++){
            if(Arrays.equals(arr1,arr2)) return true;
            if(i+s1Size < s2Size){
                arr2[s2.charAt(i)-'a']--;
                arr2[s2.charAt(i+s1Size)-'a']++;
            }
        }
        return false;
    }
}