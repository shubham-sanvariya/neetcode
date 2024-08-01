public class Reverse_Bits {
    public static void main(String[] args) {
        System.out.println(reverseBits(4));
//        System.out.println(Integer.reverse(4));
    }

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & 1) > 0) result++;
            n >>= 1;
        }
        return result;
    }
}
