public class Sum_of_Two_Integers {
    public static void main(String[] args) {
        System.out.println(getSum(2,3));
    }

    public static int getSum(int x, int y) {
        int a, b;
        do {
            a = x & y; // Carry bits
            b = x ^ y; // Sum without carry
            x = a << 1; // Shift carry to the left
            y = b;
        } while (a != 0);
        return b;
    }
}
