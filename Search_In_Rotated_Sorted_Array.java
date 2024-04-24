public class Search_In_Rotated_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        Search_In_Rotated_Sorted_Array searchInRotatedSortedArray = new Search_In_Rotated_Sorted_Array();
        searchInRotatedSortedArray.search(nums,3);
    }

    public int search(int[] nums, int target) {

        int low = 0; int high = nums.length-1;

        while(low<=high){

            int mid = (low+high)/2;
            if(nums[mid] == target) return  mid;

            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target<nums[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                if(nums[mid] < target && target<=nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }


        }
        return -1;
    }
}
