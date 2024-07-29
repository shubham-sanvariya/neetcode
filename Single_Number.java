public class Single_Number {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {2,2,1}));
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}
