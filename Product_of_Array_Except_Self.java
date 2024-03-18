import java.util.Arrays;

public class Product_of_Array_Except_Self {
    public static void main(String[] args) {
        Product_of_Array_Except_Self productOfArrayExceptSelf = new Product_of_Array_Except_Self();
        int[] nums = {-1,1,0,-3,3};
        productOfArrayExceptSelf.productExceptSelf(nums);
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int product = 1;
        for(int i = 0; i < nums.length; i++){
            result[i] = product;
            product = product * nums[i];
        }

        product = 1;
        for(int i = nums.length -1; i >= 0; i--){
            result[i] = result[i] * product;
            product = product * nums[i];
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
}
