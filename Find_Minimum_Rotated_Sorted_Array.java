public class Find_Minimum_Rotated_Sorted_Array {
    public static void main(String[] args) {
        Find_Minimum_Rotated_Sorted_Array findMinimumRotatedSortedArray = new Find_Minimum_Rotated_Sorted_Array();
        int[] nums = {3,4,5,1,2};
        findMinimumRotatedSortedArray.findMin(nums);
    }

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length -1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high-low)/2;
            //Left sorted
            if (nums[mid] >= nums[low]) {
                ans = Math.min(ans, nums[low]); // Eliminate entire left section
                low = mid + 1; // Move to right
            } else {
                ans = Math.min(ans, nums[mid]); //Eliminate entire right section
                high = mid - 1; // Move to right
            }
        }
        return ans;
    }
}
