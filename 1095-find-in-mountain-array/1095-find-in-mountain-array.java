/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peaks =  peak(mountainArr);
        int ans= binarySearch(mountainArr, target, 0, peaks);
        if(ans!= -1){
            return ans;
        }
        return binarySearch(mountainArr, target, peaks+1, mountainArr.length()-1 );
        
    }

    int binarySearch(MountainArray mountainArr,int target,int start, int end){
        boolean asc = true;
        if(mountainArr.get(start) > mountainArr.get(end)) asc = false;
        while(start<=end){
            int mid = start + (end - start)/2;
             int midVal = mountainArr.get(mid);
            if(midVal==target){
                return mid;
            }
            if(asc){
                if(midVal>target){
                    end= mid-1;
                }
                else{
                    start= mid+1;
                }
            }
            else if(!asc){
                if(midVal>target){
                    start= mid+1;
                }
                else{
                    end= mid-1;
                }
            }
        }
        return -1;
    }

    int peak(MountainArray mountainArr){
        int start =0, end = mountainArr.length() - 1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(mountainArr.get(mid) > mountainArr.get(mid + 1)){
                end = mid;
            }
            else if(mountainArr.get(mid)<mountainArr.get(mid+1)){
                start = mid+1;
            }
        }
        return start;
    }
}