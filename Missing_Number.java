public class Missing_Number {
    public static void main(String[] args) {
        int[] arr = {3,0,1};
        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int[] nums) {
        int xo = nums.length;
        for(int i=0;i<nums.length;i++){
            xo^=i ^ nums[i];
        }
        return xo;
    }
}
