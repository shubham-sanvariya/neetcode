public class Number_of_1_Bits {
    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
    }

    public static int hammingWeight(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return hammingWeight(n &(n - 1)) + 1;

    }

}
