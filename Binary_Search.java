public class Binary_Search {
    public static void main(String[] args) {
        Binary_Search binarySearch = new Binary_Search();
        binarySearch.search(new int[] {-1,0,3,5,9,12},9);
    }

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}
