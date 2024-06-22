public class Maximum_Product_Subarray {
    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        Maximum_Product_Subarray maximumProductSubarray = new Maximum_Product_Subarray();
        maximumProductSubarray.maxProduct(arr);
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        double ans =0;
        double product = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                product = 1;
                continue;
            }
            product = product * nums[i];
            ans = Math.max(ans, product);
        }

        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                product = 1;
                continue;
            }
            product = product * nums[i];
            ans = Math.max(ans, product);
        }
        System.out.println((int) ans);
        return (int)ans;
    }
}
