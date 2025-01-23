class Solution {
    public int search(int[] nums, int target) {
        // int pivot = pivot(nums);

        int end= nums.length-1, start=0;
        // if(pivot==-1){
        //     return binarySearch(nums, target, 0 , n);
        // }
        // if(nums[pivot]==target){
        //     return pivot;
        // }
        // if(nums[start]<=target){
        //     return binarySearch(nums, target, 0, pivot-1);
        // }
        // else{
        //     return binarySearch(nums, target, pivot+1, n);
        // }
        while(start<=end){
            int mid= start + (end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            // To check Left Part
            if(nums[mid]>=nums[start]){
                if(target<=nums[mid] && nums[start]<=target){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            // To check Right Part
            else{
                if(target>=nums[mid] && nums[end]>=target){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }
}
    // public int pivot(int[] nums){
    //     int start=0, end= nums.length-1;
    //     while(start<=end){
    //         int mid = start + (end-start)/2;
    //         if( end>mid && nums[mid]>nums[mid+1]){
    //             return mid;
    //         }
    //         if( start<mid && nums[mid]<nums[mid-1] ){
    //             return mid-1;
    //         }
    //         if(nums[start]>=nums[mid]){
    //             end=mid-1;
    //         }
    //         else{
    //             start=mid+1;
    //         }
    //     }
    //     return -1;
    // }
    // public int binarySearch(int[] nums, int target, int start, int end){
    //     while(start<=end){
    //         int mid = start + (end-start)/2;
    //         if(nums[mid]==target){
    //             return mid;
    //         }
    //         if(nums[mid]<target){
    //             start=mid+1;
    //         }
    //         else{
    //             end=mid-1;
    //         }
    //     }
    //     return -1;
    // }

